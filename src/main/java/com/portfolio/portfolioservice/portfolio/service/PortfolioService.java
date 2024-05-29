package com.portfolio.portfolioservice.portfolio.service;

import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.request.PortfolioFilter;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;

public interface PortfolioService {

    PortfolioResponse createPortfolio(CreatePortfolioRequest request) throws Exception;

    PortfolioResponse searchPortfolio(PortfolioFilter filter);

    PortfolioResponse getPortfolioById(String id);
}
