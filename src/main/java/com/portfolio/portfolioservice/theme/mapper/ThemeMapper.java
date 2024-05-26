package com.portfolio.portfolioservice.theme.mapper;

import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.model.request.CreateThemeRequest;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;
import org.springframework.stereotype.Component;

@Component
public class ThemeMapper {

    public Theme mapToEntity(CreateThemeRequest request) {
        Theme theme = new Theme();
        theme.setFont(request.getFont());
        theme.setDescription(request.getDescription());
        theme.setName(request.getName());
        theme.setFontSize(request.getFontSize());
        theme.setBackgroundColor(request.getBackgroundColor());
        theme.setPrimaryColor(request.getPrimaryColor());
        theme.setSecondaryColor(request.getSecondaryColor());
        theme.setTextColor(request.getTextColor());
        return theme;
    }

    public ThemeResponse mapToResponse(Theme theme) {
        ThemeResponse themeResponse = new ThemeResponse();
        themeResponse.setId(theme.getSerialId());
        themeResponse.setName(theme.getName());
        themeResponse.setDescription(theme.getDescription());
        themeResponse.setFont(theme.getFont());
        themeResponse.setFontSize(theme.getFontSize());
        themeResponse.setBackgroundColor(theme.getBackgroundColor());
        themeResponse.setPrimaryColor(theme.getPrimaryColor());
        themeResponse.setSecondaryColor(theme.getSecondaryColor());
        themeResponse.setTextColor(theme.getTextColor());
        return themeResponse;
    }
}
