/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.portfolio.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolioservice.portfolio.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, UUID> {
  Optional<Portfolio> findBySerialId(String id);
}
