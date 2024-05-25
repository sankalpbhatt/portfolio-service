package com.portfolio.portfolioservice.portfolio.model.response;

import com.portfolio.portfolioservice.portfolio.model.PersonalInformation;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;

public record PortfolioResponse(
        String id,
        ThemeResponse themeResponse,
        PersonalInformation personalInformation

) {
}
