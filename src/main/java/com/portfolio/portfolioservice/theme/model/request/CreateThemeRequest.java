package com.portfolio.portfolioservice.theme.model.request;

public class CreateThemeRequest {

    private final String name;
    private final String description;
    private final String textColor;
    private final String backgroundColor;
    private final String primaryColor;
    private final String secondaryColor;
    private final String font;
    private final Integer fontSize;

    public CreateThemeRequest(
            String name,
            String description,
            String textColor,
            String backgroundColor,
            String primaryColor,
            String secondaryColor,
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

    public String getTextColor() {
        return textColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public String getFont() {
        return font;
    }

    public Integer getFontSize() {
        return fontSize;
    }
}
