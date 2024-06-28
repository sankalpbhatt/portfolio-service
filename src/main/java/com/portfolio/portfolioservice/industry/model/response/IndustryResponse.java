package com.portfolio.portfolioservice.industry.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response of Industry resource")
public class IndustryResponse {

  private String id;
  private String industryName;
  private IndustryResponse parentIndustry;

  @Schema(description = "Image URL To be used as thumbnail for the Industry")
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

  public IndustryResponse getParentIndustry() {
    return parentIndustry;
  }

  public void setParentIndustry(IndustryResponse parentIndustry) {
    this.parentIndustry = parentIndustry;
  }

  public void setIndustryName(String industryName) {
    this.industryName = industryName;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
