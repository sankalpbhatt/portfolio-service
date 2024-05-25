package com.portfolio.portfolioservice.portfolio.mapper;

import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapper {

    public PortfolioResponse mapEntityToResponse(Portfolio portfolio) {
        return new PortfolioResponse(portfolio.getSerialId(), null, null);
    }
}

