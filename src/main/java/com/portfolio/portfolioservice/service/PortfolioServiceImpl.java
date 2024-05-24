package com.portfolio.portfolioservice.service;

import com.portfolio.portfolioservice.entity.Portfolio;
import com.portfolio.portfolioservice.mapper.PortfolioMapper;
import com.portfolio.portfolioservice.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.repository.PortfolioRepository;
import com.portfolio.portfolioservice.util.SequenceService;
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
        portfolio.setSerialId(sequenceService.getNextSequenceNumber("PORTFOLIO").toString());
        return portfolioMapper.mapEntityToResponse(
                        portfolioRepository.save(portfolioMapper.mapCreateRequestToEntity(request)));
    }
}
