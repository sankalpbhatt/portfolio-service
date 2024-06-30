/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.common.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolioservice.common.entity.SequenceNumber;
import com.portfolio.portfolioservice.common.service.SequenceService;

public interface SequenceGeneratorRepository extends JpaRepository<SequenceNumber, UUID> {

  Optional<SequenceNumber> findBySequenceType(SequenceService.SequenceType type);
}
