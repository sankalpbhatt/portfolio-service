package com.portfolio.portfolioservice.theme.service;

import com.portfolio.portfolioservice.theme.model.request.CreateThemeRequest;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;

public interface ThemeService {

    ThemeResponse getTheme(String id);

    ThemeResponse createTheme(CreateThemeRequest request) throws Exception;
}
