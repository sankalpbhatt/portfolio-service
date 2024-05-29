package com.portfolio.portfolioservice.template.controller;

import com.portfolio.portfolioservice.template.model.request.CreateTemplateRequest;
import com.portfolio.portfolioservice.template.model.response.TemplateResponse;
import com.portfolio.portfolioservice.template.service.TemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/template")
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping
    @Operation(summary = "Create Template")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(description = "API to create Template")
    public TemplateResponse createTemplate(@Validated @RequestBody CreateTemplateRequest request) throws Exception {
        return templateService.createTemplate(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Template by ID")
    @ApiResponse(description = "API to get Template")
    public TemplateResponse getTemplateById(@PathVariable(name = "id") String id) {
        return templateService.getTemplateById(id);
    }
}
