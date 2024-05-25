package com.portfolio.portfolioservice.portfolio.service;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import com.portfolio.portfolioservice.portfolio.mapper.PortfolioMapper;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;
    private final SequenceService sequenceService;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, PortfolioMapper portfolioMapper,
                                SequenceService sequenceService) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioMapper = portfolioMapper;
        this.sequenceService = sequenceService;
    }

    @Override
    public PortfolioResponse createPortfolio(CreatePortfolioRequest request) throws Exception {
        Portfolio portfolio = portfolioMapper.mapCreateRequestToEntity(request);
        portfolio.setSerialId(sequenceService.getNextSequenceNumber(SequenceService.SequenceType.PORTFOLIO).toString());
        return portfolioMapper.mapEntityToResponse(
                        portfolioRepository.save(portfolioMapper.mapCreateRequestToEntity(request)));
    }
}
