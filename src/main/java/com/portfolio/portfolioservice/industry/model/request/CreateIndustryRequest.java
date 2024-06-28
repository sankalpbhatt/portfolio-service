package com.portfolio.portfolioservice.industry.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class CreateIndustryRequest {

  @Schema(example = "Engineering")
  private String industryName;

  @Schema(example = "I0001")
  private String parentIndustryId;

  @Schema(description = "Image URL To be used as thumbnail for the Industry")
  private String imageUrl;

  public String getIndustryName() {
    return industryName;
  }

  public String getParentIndustryId() {
    return parentIndustryId;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
