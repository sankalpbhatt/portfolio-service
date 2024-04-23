package com.portfolio.portfolioservice.model;

public class PortfolioResponse {

    private String id;
    private ThemeResponse themeResponse;
    private PersonalInformation personalInformation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
