package com.portfolio.portfolioservice.portfolio.service;

import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;

public interface PortfolioService {

    PortfolioResponse createPortfolio(CreatePortfolioRequest request) throws Exception;

    PortfolioResponse getPortfolioById(String id);

    void deletePortfolio(String id);
}
