package com.portfolio.portfolioservice.industry.mapper;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.industry.entity.Industry;
import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;
import org.springframework.stereotype.Component;

@Component
public class IndustryMapper {

    private final SequenceService sequenceService;

    public IndustryMapper(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    public Industry mapToEntity(CreateIndustryRequest request) throws Exception {
        Industry industry = new Industry();
        industry.setIndustryName(request.getIndustryName());
        industry.setParentIndustryId(request.getParentIndustryId());
        industry.setImageUrl(request.getImageUrl());
        industry.setSerialId(SequenceService.SequenceType.INDUSTRY.getPrefix() +
                sequenceService.getNextSequenceNumber(SequenceService.SequenceType.INDUSTRY));
        return industry;
    }

    public IndustryResponse mapToResponse(Industry industry) {
        IndustryResponse response = new IndustryResponse();
        response.setIndustryName(industry.getIndustryName());
        response.setParentIndustryId(industry.getParentIndustryId());
        response.setImageUrl(industry.getImageUrl());
        response.setId(industry.getSerialId());
        return response;
    }
}
