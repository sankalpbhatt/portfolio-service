package com.portfolio.portfolioservice.industry.repository;

import com.portfolio.portfolioservice.industry.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface IndustryRepository extends JpaRepository<Industry, UUID>, JpaSpecificationExecutor<Industry> {

    public Optional<Industry> findBySerialId(String serialId);
}
