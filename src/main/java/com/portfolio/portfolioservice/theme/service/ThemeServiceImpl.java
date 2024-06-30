/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portfolio.portfolioservice.template.enitity.Template;
import com.portfolio.portfolioservice.template.repository.TemplateRepository;
import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.entity.specification.ThemeSpecification;
import com.portfolio.portfolioservice.theme.mapper.ThemeMapper;
import com.portfolio.portfolioservice.theme.model.request.CreateThemeRequest;
import com.portfolio.portfolioservice.theme.model.request.ThemeSearchCriteria;
import com.portfolio.portfolioservice.theme.model.response.ThemePageResponse;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;
import com.portfolio.portfolioservice.theme.repository.ThemeRepository;

@Service
public class ThemeServiceImpl implements ThemeService {

  private final ThemeRepository themeRepository;
  private final TemplateRepository templateRepository;
  private final ThemeMapper themeMapper;

  public ThemeServiceImpl(
      ThemeRepository themeRepository,
      TemplateRepository templateRepository,
      ThemeMapper themeMapper) {
    this.themeRepository = themeRepository;
    this.templateRepository = templateRepository;
    this.themeMapper = themeMapper;
  }

  @Override
  public ThemeResponse getThemeById(String id) {
    Theme theme = themeRepository.findBySerialId(id).orElseThrow();
    return themeMapper.mapToResponse(theme);
  }

  @Override
  public ThemeResponse createTheme(CreateThemeRequest request) throws Exception {
    Theme theme = themeMapper.mapToEntity(request);
    Template template = templateRepository.findBySerialId(request.templateId()).orElseThrow();
    theme.setTemplate(template);
    theme = themeRepository.save(theme);
    return themeMapper.mapToResponse(theme);
  }

  @Override
  public ThemePageResponse searchTheme(ThemeSearchCriteria searchCriteria) {
    Pageable pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getSize());
    Page<Theme> themes =
        themeRepository.findAll(
            ThemeSpecification.getThemesBySpecifications(searchCriteria), pageable);
    return themeMapper.mapToResponse(themes);
  }
}
