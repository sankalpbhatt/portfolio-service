package com.portfolio.portfolioservice.portfolio.service;

import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;

public interface PortfolioService {

    PortfolioResponse createPortfolio(CreatePortfolioRequest request) throws Exception;
}
