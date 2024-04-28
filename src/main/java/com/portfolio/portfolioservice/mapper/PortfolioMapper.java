package com.portfolio.portfolioservice.mapper;

import com.portfolio.portfolioservice.entity.Portfolio;
import com.portfolio.portfolioservice.model.PortfolioResponse;
import com.portfolio.portfolioservice.model.request.CreatePortfolioRequest;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapper {

    public Portfolio mapCreateRequestToEntity(CreatePortfolioRequest request){
        return new Portfolio();
    }

    public PortfolioResponse mapEntityToResponse(Portfolio portfolio){
        return new PortfolioResponse();
    }
}

