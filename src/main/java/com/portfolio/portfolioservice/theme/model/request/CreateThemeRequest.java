/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.model.request;

public record CreateThemeRequest(
    String name,
    String description,
    String templateId,
    PropertySet text,
    PropertySet background,
    PropertySet button,
    PropertySet border,
    PropertySet font) {}
