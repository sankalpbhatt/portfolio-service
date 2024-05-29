package com.portfolio.portfolioservice.template.service;

import com.portfolio.portfolioservice.template.model.request.CreateTemplateRequest;
import com.portfolio.portfolioservice.template.model.response.TemplateResponse;

public interface TemplateService {

    TemplateResponse createTemplate(CreateTemplateRequest request) throws Exception;

    TemplateResponse getTemplateById(String id);
}
