/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.template.service;

import org.springframework.stereotype.Service;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.template.enitity.Template;
import com.portfolio.portfolioservice.template.mapper.TemplateMapper;
import com.portfolio.portfolioservice.template.model.request.CreateTemplateRequest;
import com.portfolio.portfolioservice.template.model.response.TemplateResponse;
import com.portfolio.portfolioservice.template.repository.TemplateRepository;

@Service
public class TemplateServiceImpl implements TemplateService {

  private final TemplateRepository templateRepository;
  private final TemplateMapper templateMapper;
  private final SequenceService sequenceService;

  public TemplateServiceImpl(
      TemplateRepository templateRepository,
      TemplateMapper templateMapper,
      SequenceService sequenceService) {
    this.templateRepository = templateRepository;
    this.templateMapper = templateMapper;
    this.sequenceService = sequenceService;
  }

  @Override
  public TemplateResponse createTemplate(CreateTemplateRequest request) throws Exception {
    Template template = templateMapper.mapToEntity(request);
    template.setSerialId(
        SequenceService.SequenceType.TEMPLATE.getPrefix()
            + sequenceService.getNextSequenceNumber(SequenceService.SequenceType.TEMPLATE));
    template = templateRepository.save(template);
    return templateMapper.mapToResponse(template);
  }

  @Override
  public TemplateResponse getTemplateById(String id) {
    Template template = templateRepository.findBySerialId(id).orElseThrow();
    return templateMapper.mapToResponse(template);
  }
}
