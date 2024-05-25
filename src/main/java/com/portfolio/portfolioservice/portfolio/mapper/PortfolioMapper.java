package com.portfolio.portfolioservice.portfolio.mapper;

import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PortfolioMapper {

    public Portfolio mapCreateRequestToEntity(CreatePortfolioRequest request){
        Portfolio portfolio = new Portfolio();
        portfolio.setThemeId(UUID.fromString(request.themeId()));
        return portfolio;
    }

    public PortfolioResponse mapEntityToResponse(Portfolio portfolio){
        return new PortfolioResponse(portfolio.getSerialId(), null, null);
    }
}

