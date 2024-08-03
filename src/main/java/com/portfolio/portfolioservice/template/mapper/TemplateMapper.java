/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.template.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.portfolio.portfolioservice.template.enitity.Template;
import com.portfolio.portfolioservice.template.model.request.CreateTemplateRequest;
import com.portfolio.portfolioservice.template.model.response.TemplateResponse;

@Component
public class TemplateMapper {

  public Template mapToEntity(CreateTemplateRequest request, UUID roleId) {
    Template template = new Template();
    template.setDescription(request.description());
    template.setName(request.name());
    template.setLayout(request.layout());
    template.setRoleId(roleId);
    return template;
  }

  public TemplateResponse mapToResponse(Template template) {
    return new TemplateResponse(
        template.getSerialId(),
        template.getName(),
        template.getDescription(),
        template.getLayout(),
        template.getRoleId().toString());
  }
}
