package com.portfolio.portfolioservice.theme.mapper;

import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.model.request.CreateThemeRequest;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class ThemeMapper {

    public Theme mapToEntity(CreateThemeRequest request){
        Theme theme = new Theme();
        theme.setFont(request.getFont());
        theme.setDescription(request.getDescription());
        theme.setName(request.getName());
        theme.setFontSize(request.getFontSize());
        theme.setBackgroundColor(request.getBackgroundColor().getRGB());
        theme.setPrimaryColor(request.getPrimaryColor().getRGB());
        theme.setSecondaryColor(request.getSecondaryColor().getRGB());
        theme.setTextColor(request.getTextColor().getRGB());
        return theme;
    }

    public ThemeResponse mapToResponse(Theme theme){
        ThemeResponse themeResponse = new ThemeResponse();
        themeResponse.setId(theme.getSerialId());
        themeResponse.setName(theme.getName());
        themeResponse.setDescription(theme.getDescription());
        themeResponse.setFont(theme.getFont());
        themeResponse.setFontSize(theme.getFontSize());
        themeResponse.setBackgroundColor(new Color(theme.getBackgroundColor()));
        themeResponse.setPrimaryColor(new Color(theme.getPrimaryColor()));
        themeResponse.setSecondaryColor(new Color(theme.getSecondaryColor()));
        themeResponse.setTextColor(new Color(theme.getTextColor()));
        return themeResponse;
    }
}
