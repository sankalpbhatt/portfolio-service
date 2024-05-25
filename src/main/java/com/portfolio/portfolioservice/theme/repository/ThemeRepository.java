package com.portfolio.portfolioservice.theme.repository;

import com.portfolio.portfolioservice.theme.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ThemeRepository extends JpaRepository<Theme, UUID> {
    Optional<Theme> findBySerialId(String id);
}
