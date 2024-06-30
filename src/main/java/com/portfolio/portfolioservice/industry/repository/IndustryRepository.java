/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.industry.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.portfolio.portfolioservice.industry.entity.Industry;

public interface IndustryRepository
    extends JpaRepository<Industry, UUID>, JpaSpecificationExecutor<Industry> {

  public Optional<Industry> findBySerialId(String serialId);
}
