/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.repository;

import com.portfolio.portfolioservice.theme.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

/**
 * @author sankalpbhatt
 */
public interface ThemeRepository
        extends JpaRepository<Theme, UUID>, JpaSpecificationExecutor<Theme> {
    Optional<Theme> findBySerialId(String id);

    @Query(value = "SELECT id FROM portfolio.theme WHERE serial_id = :serialId", nativeQuery = true)
    UUID findIdBySerialId(String serialId);
}
