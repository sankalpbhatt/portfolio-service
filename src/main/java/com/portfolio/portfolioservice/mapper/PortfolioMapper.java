package com.portfolio.portfolioservice.mapper;

import com.portfolio.portfolioservice.entity.Portfolio;
import com.portfolio.portfolioservice.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.model.request.CreatePortfolioRequest;
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

