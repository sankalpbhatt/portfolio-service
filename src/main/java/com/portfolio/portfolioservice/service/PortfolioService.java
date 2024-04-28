package com.portfolio.portfolioservice.service;

import com.portfolio.portfolioservice.model.PortfolioResponse;
import com.portfolio.portfolioservice.model.request.CreatePortfolioRequest;

public interface PortfolioService {

    PortfolioResponse createPortfolio(CreatePortfolioRequest request);

}
