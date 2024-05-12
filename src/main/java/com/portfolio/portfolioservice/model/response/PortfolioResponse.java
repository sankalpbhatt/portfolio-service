package com.portfolio.portfolioservice.model.response;

import com.portfolio.portfolioservice.model.PersonalInformation;

public record PortfolioResponse(
        String id,
        ThemeResponse themeResponse,
        PersonalInformation personalInformation

) {
}
