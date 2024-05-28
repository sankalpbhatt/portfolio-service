package com.portfolio.portfolioservice.industry.mapper;

import com.portfolio.portfolioservice.industry.entity.Industry;
import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;
import org.springframework.stereotype.Component;

@Component
public class IndustryMapper {

    public Industry mapToEntity(CreateIndustryRequest request) {
        Industry industry = new Industry();
        industry.setIndustryName(request.getIndustryName());
        industry.setParentIndustryId(request.getParentIndustryId());
        industry.setImageUrl(request.getImageUrl());
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
