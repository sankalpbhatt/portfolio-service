/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.controller;

import com.portfolio.portfolioservice.theme.model.request.CreateThemeRequest;
import com.portfolio.portfolioservice.theme.model.request.ThemeSearchCriteria;
import com.portfolio.portfolioservice.theme.model.response.ThemePageResponse;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;
import com.portfolio.portfolioservice.theme.service.ThemeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theme")
@Tag(name = "Theme")
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Theme")
    public ThemeResponse createTheme(@RequestBody CreateThemeRequest request) throws Exception {
        return themeService.createTheme(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Theme by Id")
    public ThemeResponse getThemeById(@PathVariable(name = "id") String id) {
        return themeService.getThemeById(id);
    }

    @GetMapping
    @Operation(summary = "Search Theme")
    public ThemePageResponse searchTheme(@ParameterObject ThemeSearchCriteria searchCriteria) {
        return themeService.searchTheme(searchCriteria);
    }
}
