package com.portfolio.portfolioservice.industry.model.response;

import java.util.UUID;

public class IndustryResponse {

    private String id;
    private String industryName;
    private UUID parentIndustryId;
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public UUID getParentIndustryId() {
        return parentIndustryId;
    }

    public void setParentIndustryId(UUID parentIndustryId) {
        this.parentIndustryId = parentIndustryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
