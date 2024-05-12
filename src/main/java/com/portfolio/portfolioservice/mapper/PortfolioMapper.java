package com.portfolio.portfolioservice.mapper;

import com.portfolio.portfolioservice.entity.Portfolio;
import com.portfolio.portfolioservice.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.model.response.ThemeResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PortfolioMapper {

    public Portfolio mapCreateRequestToEntity(CreatePortfolioRequest request){
        return new Portfolio(null, "1", UUID.fromString(request.themeId()));
    }

    public PortfolioResponse mapEntityToResponse(Portfolio portfolio){
        return new PortfolioResponse(portfolio.serialId(), null, null);
    }
}

