/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateThemeRequest(
        @Schema(description = "Theme name") String name,
        @Schema(description = "Description of the theme") String description,
        @Schema(example = "T1") String templateId,
        @Schema(description = "Text properties to be used in theme") PropertySet text,
        @Schema(description = "Background properties to be used in theme") PropertySet background,
        @Schema(description = "Button properties to be used in theme") PropertySet button,
        @Schema(description = "Border properties to be used in theme") PropertySet border,
        @Schema(description = "Font properties to be used in theme") PropertySet font) {
}
