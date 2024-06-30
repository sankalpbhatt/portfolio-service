/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.industry.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portfolioservice.industry.entity.Industry;
import com.portfolio.portfolioservice.industry.entity.specification.IndustrySpecification;
import com.portfolio.portfolioservice.industry.mapper.IndustryMapper;
import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.request.IndustrySearchCriteria;
import com.portfolio.portfolioservice.industry.model.response.IndustryPageResponse;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;
import com.portfolio.portfolioservice.industry.repository.IndustryRepository;

@Service
public class IndustryServiceImpl implements IndustryService {

  private final IndustryRepository industryRepository;
  private final IndustryMapper industryMapper;

  public IndustryServiceImpl(IndustryRepository industryRepository, IndustryMapper industryMapper) {
    this.industryRepository = industryRepository;
    this.industryMapper = industryMapper;
  }

  @Override
  @Transactional
  public IndustryResponse createIndustry(CreateIndustryRequest request) throws Exception {
    Industry industry = industryMapper.mapToEntity(request);
    industry.setParentIndustry(
        industryRepository.findBySerialId(request.getParentIndustryId()).orElseThrow());
    industry = industryRepository.save(industry);
    return industryMapper.mapToResponse(industry);
  }

  @Override
  public IndustryResponse getIndustryBySerialId(String id) {
    Industry industry = industryRepository.findBySerialId(id).orElseThrow();
    return industryMapper.mapToResponse(industry);
  }

  @Override
  public IndustryResponse getIndustryById(UUID id) {
    Industry industry = industryRepository.findById(id).orElseThrow();
    return industryMapper.mapToResponse(industry);
  }

  @Override
  public IndustryPageResponse searchIndustry(IndustrySearchCriteria industrySearchCriteria) {
    Pageable pageable =
        PageRequest.of(industrySearchCriteria.getPage(), industrySearchCriteria.getSize());
    Page<Industry> industries =
        industryRepository.findAll(
            IndustrySpecification.getIndustriesByCriteria(industrySearchCriteria), pageable);
    return industryMapper.mapToResponse(industries);
  }

  @Override
  public void deleteIndustry(String id) {
    Industry industry = industryRepository.findBySerialId(id).orElseThrow();
    industry.setDeletedAt(LocalDateTime.now());
    industryRepository.save(industry);
  }
}
