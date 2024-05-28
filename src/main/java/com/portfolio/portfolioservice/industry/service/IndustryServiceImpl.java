package com.portfolio.portfolioservice.industry.service;

import com.portfolio.portfolioservice.industry.entity.Industry;
import com.portfolio.portfolioservice.industry.mapper.IndustryMapper;
import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.request.IndustryFilter;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;
import com.portfolio.portfolioservice.industry.repository.IndustryRepository;
import org.springframework.transaction.annotation.Transactional;

public class IndustryServiceImpl implements IndustryService {

    private final IndustryRepository industryRepository;
    private final IndustryMapper industryMapper;

    public IndustryServiceImpl(IndustryRepository industryRepository, IndustryMapper industryMapper) {
        this.industryRepository = industryRepository;
        this.industryMapper = industryMapper;
    }

    @Override
    @Transactional
    public IndustryResponse createIndustry(CreateIndustryRequest request) {
        Industry industry = industryMapper.mapToEntity(request);
        industry = industryRepository.save(industry);
        return industryMapper.mapToResponse(industry);
    }

    @Override
    public IndustryResponse getIndustry(String id) {
        Industry industry = industryRepository.findBySerialId(id).orElseThrow();
        return industryMapper.mapToResponse(industry);
    }

    @Override
    public IndustryPageResponse searchIndustry(IndustryFilter filter) {
        return null;
    }
}
