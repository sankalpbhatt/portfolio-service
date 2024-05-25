package com.portfolio.portfolioservice.common.repository;

import com.portfolio.portfolioservice.common.entity.SequenceNumber;
import com.portfolio.portfolioservice.common.service.SequenceService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface SequenceGeneratorRepository extends JpaRepository<SequenceNumber, UUID> {

    Optional<SequenceNumber> findBySequenceType(SequenceService.SequenceType type);
}
