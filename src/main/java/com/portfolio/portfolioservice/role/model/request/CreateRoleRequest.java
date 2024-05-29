package com.portfolio.portfolioservice.role.model.request;

import java.util.UUID;

public class CreateRoleRequest {

    private String name;
    private UUID industryId;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public UUID getIndustryId() {
        return industryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
