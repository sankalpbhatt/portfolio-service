/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.role.model.response;

import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;

public class RoleResponse {

  private String id;
  private String name;
  private IndustryResponse industry;
  private String imageUrl;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public IndustryResponse getIndustry() {
    return industry;
  }

  public void setIndustry(IndustryResponse industry) {
    this.industry = industry;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
