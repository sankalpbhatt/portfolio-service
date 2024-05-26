package com.portfolio.portfolioservice.portfolio.controller;

import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.request.PortfolioFilter;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioPageResponse;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.portfolio.service.PortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Portfolio by ID")
    public PortfolioResponse getPortfolioById(@PathVariable("id") @NotNull String id) {
        return new PortfolioResponse(id, null, null);
    }

    @PostMapping
    @Operation(summary = "Create Portfolio")
    @ResponseStatus(HttpStatus.CREATED)
    public PortfolioResponse createPortfolio(@RequestBody CreatePortfolioRequest request) throws Exception {
        return portfolioService.createPortfolio(request);
    }

    @GetMapping
    @Operation(summary = "Search Portfolio")
    public PortfolioResponse searchPortfolio(@ParameterObject PortfolioFilter filter) throws Exception {
        return portfolioService.searchPortfolio(filter);
    }

    @PatchMapping
    public PortfolioPageResponse updatePortfolio() {
        return null;
    }

    @DeleteMapping("/{id}")
    public Integer deletePortfolio(@PathVariable("id") int id) {
        return null;
    }
}
