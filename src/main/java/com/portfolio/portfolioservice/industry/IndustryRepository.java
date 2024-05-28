package com.portfolio.portfolioservice.industry;

import com.portfolio.portfolioservice.industry.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IndustryRepository extends JpaRepository<Industry, UUID> {
}
