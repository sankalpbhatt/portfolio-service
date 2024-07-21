/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.template.service;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.exception.PortfolioException;
import com.portfolio.portfolioservice.exception.model.ErrorCode;
import com.portfolio.portfolioservice.role.repository.RoleRepository;
import com.portfolio.portfolioservice.template.enitity.Template;
import com.portfolio.portfolioservice.template.mapper.TemplateMapper;
import com.portfolio.portfolioservice.template.model.request.CreateTemplateRequest;
import com.portfolio.portfolioservice.template.model.response.TemplateResponse;
import com.portfolio.portfolioservice.template.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;
    private final RoleRepository roleRepository;
    private final TemplateMapper templateMapper;
    private final SequenceService sequenceService;

    public TemplateServiceImpl(
            TemplateRepository templateRepository,
            RoleRepository roleRepository,
            TemplateMapper templateMapper,
            SequenceService sequenceService) {
        this.templateRepository = templateRepository;
        this.roleRepository = roleRepository;
        this.templateMapper = templateMapper;
        this.sequenceService = sequenceService;
    }

    @Override
    public TemplateResponse createTemplate(CreateTemplateRequest request) throws Exception {

        UUID roleId = roleRepository.findBySerialId(request.roleId()).orElseThrow(() -> new PortfolioException(
                String.format("Role %s does not exists", request.roleId()), ErrorCode.BUSINESS_ERROR
        )).getId();

        Template template = templateMapper.mapToEntity(request, roleId);

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
