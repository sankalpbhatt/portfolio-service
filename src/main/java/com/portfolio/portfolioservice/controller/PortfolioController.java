package com.portfolio.portfolioservice.controller;

import com.portfolio.portfolioservice.model.PortfolioResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @GetMapping("/{id}")
    public PortfolioResponse getPortfolioById(){
        return new PortfolioResponse();
    }

}
