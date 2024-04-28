package com.portfolio.portfolioservice.controller;

import com.portfolio.portfolioservice.model.PortfolioResponse;
import com.portfolio.portfolioservice.model.request.CreatePortfolioRequest;
import com.portfolio.portfolioservice.service.PortfolioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    PortfolioController(PortfolioService portfolioService){
        this.portfolioService = portfolioService;
    }

    @GetMapping("/{id}")
    public PortfolioResponse getPortfolioById(@PathVariable("id") String id){
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        portfolioResponse.setId(id);
        return portfolioResponse;
    }

    @PostMapping("/{id}")
    public PortfolioResponse createPortfolio(CreatePortfolioRequest request){
        return portfolioService.createPortfolio(request);
    }
}
