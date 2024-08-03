/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.exception.PortfolioException;
import com.portfolio.portfolioservice.exception.model.ErrorCode;
import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.model.request.CreateThemeRequest;
import com.portfolio.portfolioservice.theme.model.request.PropertySet;
import com.portfolio.portfolioservice.theme.model.response.ThemePageResponse;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;

@Component
public class ThemeMapper {

  private final SequenceService sequenceService;

  private final ObjectMapper objectMapper;

  public ThemeMapper(SequenceService sequenceService, ObjectMapper objectMapper) {
    this.sequenceService = sequenceService;
    this.objectMapper = objectMapper;
  }

  public Theme mapToEntity(CreateThemeRequest request) throws Exception {
    Theme theme = new Theme();
    /*theme.setText(objectMapper.writeValueAsString(request.text()));
    theme.setName(request.name());
    theme.setBackground(objectMapper.writeValueAsString(request.background()));
    theme.setBorder(objectMapper.writeValueAsString(request.border()));
    theme.setButton(objectMapper.writeValueAsString(request.button()));
    theme.setFont(objectMapper.writeValueAsString(request.font()));*/
    theme.setText(objectMapper.writeValueAsString(request.text()));
    theme.setName(request.name());
    theme.setBackground(objectMapper.writeValueAsString(request.background()));
    theme.setBorder(objectMapper.writeValueAsString(request.border()));
    theme.setButton(objectMapper.writeValueAsString(request.button()));
    theme.setFont(objectMapper.writeValueAsString(request.font()));
    theme.setDescription(request.description());
    theme.setSerialId(
        SequenceService.SequenceType.THEME.getPrefix()
            + sequenceService.getNextSequenceNumber(SequenceService.SequenceType.THEME));
    return theme;
  }

  public ThemeResponse mapToResponse(Theme theme) {
    ThemeResponse themeResponse;

    try {
      themeResponse =
          new ThemeResponse(
              theme.getSerialId(),
              theme.getName(),
              theme.getDescription(),
              theme.getTemplate().getSerialId(),
              /*objectMapper.readValue(theme.getText(), PropertySet.class),
              objectMapper.readValue(theme.getBackground(), PropertySet.class),
              objectMapper.readValue(theme.getButton(), PropertySet.class),
              objectMapper.readValue(theme.getBorder(), PropertySet.class),
              objectMapper.readValue(theme.getFont(), PropertySet.class)*/
              objectMapper.readValue(theme.getText(), PropertySet.class),
              objectMapper.readValue(theme.getBackground(), PropertySet.class),
              objectMapper.readValue(theme.getButton(), PropertySet.class),
              objectMapper.readValue(theme.getBorder(), PropertySet.class),
              objectMapper.readValue(theme.getFont(), PropertySet.class));
    } catch (JsonProcessingException e) {
      throw new PortfolioException("Error converting Theme Entity to Response", ErrorCode.GENERAL);
    }

    return themeResponse;
  }

  public ThemePageResponse mapToResponse(Page<Theme> themes) {
    List<ThemeResponse> themeResponses = themes.stream().map(this::mapToResponse).toList();
    ThemePageResponse response = new ThemePageResponse();
    response.setContent(themeResponses);
    response.setPageNumber(themes.getNumber());
    response.setPageSize(themes.getSize());
    response.setTotalElements(themes.getTotalElements());
    response.setTotalPages(themes.getTotalPages());
    return response;
  }
}
