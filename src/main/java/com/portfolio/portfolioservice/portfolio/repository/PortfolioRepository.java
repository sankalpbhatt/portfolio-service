package com.portfolio.portfolioservice.portfolio.repository;

import com.portfolio.portfolioservice.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PortfolioRepository extends JpaRepository<Portfolio, UUID> {
}
