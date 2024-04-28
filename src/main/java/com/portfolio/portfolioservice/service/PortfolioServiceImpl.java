package com.portfolio.portfolioservice.service;

import com.portfolio.portfolioservice.mapper.PortfolioMapper;
import com.portfolio.portfolioservice.model.PortfolioResponse;
import com.portfolio.portfolioservice.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.repository.PortfolioRepository;

public class PortfolioServiceImpl implements PortfolioService{

    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, PortfolioMapper portfolioMapper) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioMapper = portfolioMapper;
    }

    @Override
    public PortfolioResponse createPortfolio(CreatePortfolioRequest request) {
        return portfolioMapper
                .mapEntityToResponse(
                        portfolioRepository.save(portfolioMapper.mapCreateRequestToEntity(request)));
    }
}
