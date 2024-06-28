package com.portfolio.portfolioservice.theme.service;

import com.portfolio.portfolioservice.theme.model.request.CreateThemeRequest;
import com.portfolio.portfolioservice.theme.model.request.ThemeSearchCriteria;
import com.portfolio.portfolioservice.theme.model.response.ThemePageResponse;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;

public interface ThemeService {

  ThemeResponse getThemeById(String id);

  ThemeResponse createTheme(CreateThemeRequest request) throws Exception;

  ThemePageResponse searchTheme(ThemeSearchCriteria searchCriteria);
}
