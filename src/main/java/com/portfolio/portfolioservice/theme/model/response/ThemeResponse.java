/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.model.response;

import com.portfolio.portfolioservice.theme.model.request.PropertySet;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public record ThemeResponse(

        @Schema(example = "T001")
        String id,
        String name,
        String description,
        String templateId,
        PropertySet text,
        PropertySet background,
        PropertySet button,
        PropertySet border,
        PropertySet font) {
}

