package com.portfolio.portfolioservice.portfolio.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema
public record CreatePortfolioRequest(
        @NotNull @Schema(example = "T001") String themeId,
        String description,
        @NotNull @Schema(example = "U001") String userInfoId,
        String bio) {
}
