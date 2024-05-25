package com.portfolio.portfolioservice.repository;

import com.portfolio.portfolioservice.entity.PortfolioSequenceNumber;
import com.portfolio.portfolioservice.service.SequenceService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface SequenceGeneratorRepository extends JpaRepository<PortfolioSequenceNumber, UUID> {

    Optional<PortfolioSequenceNumber> findBySequenceType(SequenceService.SequenceType type);
}
