package com.portfolio.portfolioservice.industry.mapper;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.industry.entity.Industry;
import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.response.IndustryPageResponse;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class IndustryMapper {

    private final SequenceService sequenceService;

    public IndustryMapper(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    public Industry mapToEntity(CreateIndustryRequest request) throws Exception {
        Industry industry = new Industry();
        industry.setIndustryName(request.getIndustryName());
        industry.setImageUrl(request.getImageUrl());
        industry.setSerialId(SequenceService.SequenceType.INDUSTRY.getPrefix() +
                sequenceService.getNextSequenceNumber(SequenceService.SequenceType.INDUSTRY));
        return industry;
    }

    public IndustryResponse mapToResponse(Industry industry) {
        if (Objects.isNull(industry)) {
            return null;
        }
        IndustryResponse response = new IndustryResponse();
        response.setIndustryName(industry.getIndustryName());
        response.setParentIndustry(mapToResponse(industry.getParentIndustry()));
        response.setImageUrl(industry.getImageUrl());
        response.setId(industry.getSerialId());
        return response;
    }

    public IndustryPageResponse mapToResponse(Page<Industry> industries) {
        IndustryPageResponse response = new IndustryPageResponse();
        response.setContent(industries.stream().map(this::mapToResponse).toList());
        response.setPageNumber(industries.getNumber());
        response.setPageSize(industries.getSize());
        response.setTotalElements(industries.getTotalElements());
        response.setTotalPages(industries.getTotalPages());
        return response;
    }
}
