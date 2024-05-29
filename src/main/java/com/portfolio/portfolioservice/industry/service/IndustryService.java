package com.portfolio.portfolioservice.industry.service;

import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.request.IndustryFilter;
import com.portfolio.portfolioservice.industry.model.response.IndustryPageResponse;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;

public interface IndustryService {

    IndustryResponse createIndustry(CreateIndustryRequest request);

    IndustryResponse getIndustryById(String id);

    IndustryPageResponse searchIndustry(IndustryFilter filter);
}
