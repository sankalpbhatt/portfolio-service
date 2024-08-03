/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.portfolio.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema
public record CreatePortfolioRequest(
        @NotNull @Schema(example = "T1") String themeId,
        @Schema(description = "Description of the portfolio") String description,
        @NotNull @Schema(example = "U1") String userInfoId,
        @Schema(description = "Bio of the user") String bio,
        @NotNull @Schema(example = "R1", description = "Role id for the portfolio") String roleId) {
}
