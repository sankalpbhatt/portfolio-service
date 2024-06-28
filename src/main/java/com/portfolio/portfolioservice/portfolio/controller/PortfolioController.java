package com.portfolio.portfolioservice.portfolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portfolioservice.portfolio.model.request.AddPortfolioDetailsRequest;
import com.portfolio.portfolioservice.portfolio.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioPageResponse;
import com.portfolio.portfolioservice.portfolio.model.response.PortfolioResponse;
import com.portfolio.portfolioservice.portfolio.service.PortfolioService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

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
    return portfolioService.getPortfolioById(id);
  }

  @PostMapping
  @Operation(summary = "Create Portfolio")
  @ResponseStatus(HttpStatus.CREATED)
  public PortfolioResponse createPortfolio(@RequestBody @Valid CreatePortfolioRequest request)
      throws Exception {
    return portfolioService.createPortfolio(request);
  }

  @PutMapping
  @Operation(summary = "Add Portfolio Details")
  @ResponseStatus(HttpStatus.CREATED)
  public <T> PortfolioResponse addPortfolioDetail(
      @RequestBody @Valid AddPortfolioDetailsRequest<T> request) throws Exception {
    return portfolioService.addPortfolioDetails(request);
  }

  @PatchMapping
  public PortfolioPageResponse updatePortfolio() {
    return null;
  }

  @DeleteMapping("/{id}")
  public void deletePortfolio(@PathVariable("id") String id) {
    portfolioService.deletePortfolio(id);
  }
}
