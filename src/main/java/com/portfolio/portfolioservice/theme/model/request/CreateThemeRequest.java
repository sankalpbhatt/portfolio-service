package com.portfolio.portfolioservice.theme.model.request;

import java.awt.*;

public class CreateThemeRequest {

    private final String name;
    private final String description;
    private final Color textColor;
    private final Color backgroundColor;
    private final Color primaryColor;
    private final Color secondaryColor;
    private final String font;
    private final Integer fontSize;

    public CreateThemeRequest(
            String name,
            String description,
            Color textColor,
            Color backgroundColor,
            Color primaryColor,
            Color secondaryColor,
            String font,
            Integer fontSize) {
        this.name = name;
        this.description = description;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.font = font;
        this.fontSize = fontSize;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Color getTextColor() {
        return textColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public String getFont() {
        return font;
    }

    public Integer getFontSize() {
        return fontSize;
    }
}
