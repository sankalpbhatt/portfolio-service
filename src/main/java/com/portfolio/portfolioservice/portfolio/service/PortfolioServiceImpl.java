package com.portfolio.portfolioservice.portfolio.service;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import com.portfolio.portfolioservice.portfolio.mapper.PortfolioMapper;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.portfolio.repository.PortfolioRepository;
import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.repository.ThemeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;
    private final SequenceService sequenceService;
    private final ThemeRepository themeRepository;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, PortfolioMapper portfolioMapper,
                                SequenceService sequenceService, ThemeRepository themeRepository) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioMapper = portfolioMapper;
        this.sequenceService = sequenceService;
        this.themeRepository = themeRepository;
    }

    @Override
    @Transactional
    public PortfolioResponse createPortfolio(CreatePortfolioRequest request) throws Exception {
        Portfolio portfolio = new Portfolio();
        Theme theme = themeRepository.findBySerialId(request.themeId()).orElseThrow();
        portfolio.setThemeId(theme.getId());
        portfolio.setDescription(request.description());
        portfolio.setSerialId(SequenceService.SequenceType.PORTFOLIO.getPrefix() +
                sequenceService.getNextSequenceNumber(SequenceService.SequenceType.PORTFOLIO));
        return portfolioMapper.mapEntityToResponse(
                portfolioRepository.save(portfolio));
    }
}
