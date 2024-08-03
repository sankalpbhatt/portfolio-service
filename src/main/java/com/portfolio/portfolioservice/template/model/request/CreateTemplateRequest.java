/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.template.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CreateTemplateRequest(
        @NotNull @Schema(title = "Name", name = "name", description = "Template name") String name,
        @Schema(description = "Description of the template") String description,
        @Schema(description = "layout JSON of the Template") @NotNull String layout,
        @Schema(example = "R1") String roleId) {
}
