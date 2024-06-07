package com.portfolio.portfolioservice.theme.service;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.entity.specification.ThemeSpecification;
import com.portfolio.portfolioservice.theme.mapper.ThemeMapper;
import com.portfolio.portfolioservice.theme.model.request.CreateThemeRequest;
import com.portfolio.portfolioservice.theme.model.request.ThemeSearchCriteria;
import com.portfolio.portfolioservice.theme.model.response.ThemePageResponse;
import com.portfolio.portfolioservice.theme.model.response.ThemeResponse;
import com.portfolio.portfolioservice.theme.repository.ThemeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;
    private final ThemeMapper themeMapper;
    private final SequenceService sequenceService;

    public ThemeServiceImpl(
            ThemeRepository themeRepository,
            ThemeMapper themeMapper,
            SequenceService sequenceService) {
        this.themeRepository = themeRepository;
        this.themeMapper = themeMapper;
        this.sequenceService = sequenceService;
    }

    @Override
    public ThemeResponse getThemeById(String id) {
        Theme theme = themeRepository.findBySerialId(id).orElseThrow();
        return themeMapper.mapToResponse(theme);
    }

    @Override
    public ThemeResponse createTheme(CreateThemeRequest request) throws Exception {
        Theme theme = themeMapper.mapToEntity(request);
        theme.setSerialId(SequenceService.SequenceType.THEME.getPrefix() +
                sequenceService.getNextSequenceNumber(SequenceService.SequenceType.THEME));
        theme = themeRepository.save(theme);
        return themeMapper.mapToResponse(theme);
    }

    @Override
    public ThemePageResponse searchTheme(ThemeSearchCriteria searchCriteria) {
        Pageable pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getSize());
        Page<Theme> themes = themeRepository
                .findAll(ThemeSpecification.getThemesBySpecifications(searchCriteria), pageable);
        return themeMapper.mapToResponse(themes);
    }
}
