package com.portfolio.portfolioservice.industry.controller;

import com.portfolio.portfolioservice.industry.model.request.CreateIndustryRequest;
import com.portfolio.portfolioservice.industry.model.request.IndustrySearchCriteria;
import com.portfolio.portfolioservice.industry.model.response.IndustryPageResponse;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;
import com.portfolio.portfolioservice.industry.service.IndustryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/industry")
@Validated
public class IndustryController {

    private final IndustryService industryService;

    public IndustryController(IndustryService industryService) {
        this.industryService = industryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new Industry")
    public IndustryResponse createIndustry(@RequestBody @Valid CreateIndustryRequest request) throws Exception {
        return industryService.createIndustry(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Industry by ID")
    public IndustryResponse getIndustryById(@PathVariable(name = "id") String id) {
        return industryService.getIndustryBySerialId(id);
    }

    @GetMapping
    @Operation(summary = "Search Industry")
    public IndustryPageResponse searchIndustry(@ParameterObject IndustrySearchCriteria industrySearchCriteria) {
        return industryService.searchIndustry(industrySearchCriteria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete industry")
    public void deleteIndustry(@PathVariable @NotNull String id) {
        industryService.deleteIndustry(id);
    }
}
