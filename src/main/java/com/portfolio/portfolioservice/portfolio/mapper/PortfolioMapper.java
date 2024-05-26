package com.portfolio.portfolioservice.portfolio.mapper;

import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapper {

    public Portfolio mapToEntity(CreatePortfolioRequest createPortfolioRequest) {
        Portfolio portfolio = new Portfolio();
        portfolio.setDescription(createPortfolioRequest.description());
        portfolio.setBio(createPortfolioRequest.bio());
        return portfolio;
    }

    public PortfolioResponse mapEntityToResponse(Portfolio portfolio) {
        return new PortfolioResponse(portfolio.getSerialId(), null, null);
    }
}

