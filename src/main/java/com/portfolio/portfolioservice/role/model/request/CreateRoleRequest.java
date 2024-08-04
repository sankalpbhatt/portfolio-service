/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.role.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class CreateRoleRequest {

  @Schema(description = "Name of the role")
  private String name;

  @Schema(example = "I1", description = "String id of the Industry against which role is created")
  private String industryId;

  @Schema(description = "Image URL for the role")
  private String imageUrl;

  public String getName() {
    return name;
  }

  public String getIndustryId() {
    return industryId;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
