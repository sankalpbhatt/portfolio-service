package com.portfolio.portfolioservice.industry.model.request;

import java.util.UUID;

public class CreateIndustryRequest {

    private String industryName;
    private UUID parentIndustryId;
    private String imageUrl;

    public String getIndustryName() {
        return industryName;
    }

    public UUID getParentIndustryId() {
        return parentIndustryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
