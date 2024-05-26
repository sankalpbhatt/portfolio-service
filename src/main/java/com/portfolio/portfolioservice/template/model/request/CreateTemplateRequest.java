package com.portfolio.portfolioservice.template.model.request;

import jakarta.validation.constraints.NotNull;

public record CreateTemplateRequest(
        @NotNull String name,
        String description,
        @NotNull String layout) {
}
