package com.portfolio.portfolioservice.portfolio.mapper;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapper {

    private final SequenceService sequenceService;

    public PortfolioMapper(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    public Portfolio mapToEntity(CreatePortfolioRequest createPortfolioRequest) throws Exception {
        Portfolio portfolio = new Portfolio();
        portfolio.setSerialId(SequenceService.SequenceType.PORTFOLIO.getPrefix() +
                sequenceService.getNextSequenceNumber(SequenceService.SequenceType.PORTFOLIO));
        portfolio.setDescription(createPortfolioRequest.description());
        portfolio.setBio(createPortfolioRequest.bio());
        return portfolio;
    }

    public PortfolioResponse mapEntityToResponse(Portfolio portfolio) {
        return new PortfolioResponse(portfolio.getSerialId(), null, null);
    }
}

