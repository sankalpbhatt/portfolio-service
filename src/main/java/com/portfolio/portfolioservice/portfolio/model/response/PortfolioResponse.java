package com.portfolio.portfolioservice.portfolio.model.response;

import com.portfolio.portfolioservice.portfolio.model.PersonalInformation;

public record PortfolioResponse(
        String id,
        ThemeResponse themeResponse,
        PersonalInformation personalInformation

) {
}
