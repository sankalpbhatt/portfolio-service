package com.portfolio.portfolioservice.portfolio.service;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import com.portfolio.portfolioservice.portfolio.mapper.PortfolioMapper;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.portfolio.repository.PortfolioRepository;
import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.repository.ThemeRepository;
import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import com.portfolio.portfolioservice.userinfo.repository.UserInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;
    private final SequenceService sequenceService;
    private final ThemeRepository themeRepository;
    private final UserInfoRepository userInfoRepository;

    public PortfolioServiceImpl(
            PortfolioRepository portfolioRepository,
            PortfolioMapper portfolioMapper,
            SequenceService sequenceService,
            ThemeRepository themeRepository,
            UserInfoRepository userInfoRepository) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioMapper = portfolioMapper;
        this.sequenceService = sequenceService;
        this.themeRepository = themeRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    @Transactional
    public PortfolioResponse createPortfolio(CreatePortfolioRequest request) throws Exception {
        Portfolio portfolio = portfolioMapper.mapToEntity(request);
        Theme theme = themeRepository.findBySerialId(request.themeId()).orElseThrow();
        UserInfo userInfo = userInfoRepository.findBySerialId(request.userInfoId()).orElseThrow();
        portfolio.setThemeId(theme.getId());
        portfolio.setUserInfoId(userInfo.getId());
        portfolio.setSerialId(SequenceService.SequenceType.PORTFOLIO.getPrefix() +
                sequenceService.getNextSequenceNumber(SequenceService.SequenceType.PORTFOLIO));
        return portfolioMapper.mapEntityToResponse(
                portfolioRepository.save(portfolio));
    }

    @Override
    public PortfolioResponse getPortfolioById(String id) {
        return portfolioMapper.mapEntityToResponse(portfolioRepository.findBySerialId(id).orElseThrow());
    }

    @Override
    public void deletePortfolio(String id) {
        Portfolio portfolio = portfolioRepository.findBySerialId(id).orElseThrow();
        portfolio.setDeletedAt(LocalDateTime.now());
        portfolioRepository.save(portfolio);
    }
}
