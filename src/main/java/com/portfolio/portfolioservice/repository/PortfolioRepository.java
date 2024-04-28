package com.portfolio.portfolioservice.repository;

import com.portfolio.portfolioservice.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PortfolioRepository extends JpaRepository<Portfolio, UUID> {
}
