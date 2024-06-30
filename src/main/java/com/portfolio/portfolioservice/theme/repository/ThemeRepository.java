/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.portfolioservice.theme.entity.Theme;

/**
 * @author sankalpbhatt
 */
public interface ThemeRepository
    extends JpaRepository<Theme, UUID>, JpaSpecificationExecutor<Theme> {
  Optional<Theme> findBySerialId(String id);

  @Query(value = "SELECT id FROM portfolio.theme WHERE serial_id = :serialId", nativeQuery = true)
  Optional<UUID> findIdBySerialId(String id);
}
