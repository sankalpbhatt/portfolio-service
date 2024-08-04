/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.portfolio.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import com.portfolio.portfolioservice.portfolio.mapper.PortfolioMapper;
import com.portfolio.portfolioservice.portfolio.model.request.AddPortfolioDetailsRequest;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.portfolio.repository.PortfolioRepository;
import com.portfolio.portfolioservice.theme.repository.ThemeRepository;
import com.portfolio.portfolioservice.userinfo.repository.UserInfoRepository;

@Service
public class PortfolioServiceImpl implements PortfolioService {

  private final PortfolioRepository portfolioRepository;
  private final PortfolioMapper portfolioMapper;
  private final ThemeRepository themeRepository;
  private final UserInfoRepository userInfoRepository;

  public PortfolioServiceImpl(
      PortfolioRepository portfolioRepository,
      PortfolioMapper portfolioMapper,
      ThemeRepository themeRepository,
      UserInfoRepository userInfoRepository) {
    this.portfolioRepository = portfolioRepository;
    this.portfolioMapper = portfolioMapper;
    this.themeRepository = themeRepository;
    this.userInfoRepository = userInfoRepository;
  }

  @Override
  @Transactional
  public PortfolioResponse createPortfolio(CreatePortfolioRequest request) throws Exception {
    Portfolio portfolio = portfolioMapper.mapToEntity(request);
    UUID themeId = themeRepository.findIdBySerialId(request.themeId());
    UUID userInfoId = userInfoRepository.findIdBySerialId(request.userInfoId()).orElseThrow();
    portfolio.setThemeId(themeId);
    portfolio.setUserInfoId(userInfoId);
    return portfolioMapper.mapEntityToResponse(portfolioRepository.save(portfolio));
  }

  @Override
  @Transactional
  public <T> PortfolioResponse addPortfolioDetails(AddPortfolioDetailsRequest<T> request) {
    return null;
  }

  @Override
  public PortfolioResponse getPortfolioById(String id) {
    return portfolioMapper.mapEntityToResponse(
        portfolioRepository.findBySerialId(id).orElseThrow());
  }

  @Override
  public void deletePortfolio(String id) {
    Portfolio portfolio = portfolioRepository.findBySerialId(id).orElseThrow();
    portfolio.setDeletedAt(LocalDateTime.now());
    portfolioRepository.save(portfolio);
  }
}
