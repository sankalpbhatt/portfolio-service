package com.portfolio.portfolioservice.industry.service;

import java.util.UUID;

import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.request.IndustrySearchCriteria;
import com.portfolio.portfolioservice.industry.model.response.IndustryPageResponse;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;

public interface IndustryService {

  IndustryResponse createIndustry(CreateIndustryRequest request) throws Exception;

  IndustryResponse getIndustryBySerialId(String id);

  IndustryResponse getIndustryById(UUID id);

  IndustryPageResponse searchIndustry(IndustrySearchCriteria industrySearchCriteria);

  void deleteIndustry(String id);
}
