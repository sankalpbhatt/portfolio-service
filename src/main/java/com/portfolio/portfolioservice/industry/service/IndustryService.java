package com.portfolio.portfolioservice.industry.service;

import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.request.IndustryFilter;
import com.portfolio.portfolioservice.industry.model.response.IndustryPageResponse;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;

import java.util.UUID;

public interface IndustryService {

    IndustryResponse createIndustry(CreateIndustryRequest request) throws Exception;

    IndustryResponse getIndustryBySerialId(String id);

    IndustryResponse getIndustryById(UUID id);

    IndustryPageResponse searchIndustry(IndustryFilter filter);
}
