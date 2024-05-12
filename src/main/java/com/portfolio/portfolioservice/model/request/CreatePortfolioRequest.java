package com.portfolio.portfolioservice.model.request;

public record CreatePortfolioRequest(
        String themeId,
        PersonalInformationRequest personalInformationRequest) { }
