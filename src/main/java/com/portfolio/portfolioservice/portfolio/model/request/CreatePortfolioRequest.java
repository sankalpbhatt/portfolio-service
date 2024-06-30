/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.portfolio.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema
public record CreatePortfolioRequest(
    @NotNull @Schema(example = "T001") String themeId,
    @Schema(description = "Description of the portfolio") String description,
    @NotNull @Schema(example = "U001") String userInfoId,
    @Schema(description = "Bio of the user") String bio,
    @NotNull @Schema(description = "Role id for the portfolio") String roleId) {}
