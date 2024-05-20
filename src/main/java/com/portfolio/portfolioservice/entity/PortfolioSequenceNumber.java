package com.portfolio.portfolioservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sequence_numbers")
public record PortfolioSequenceNumber(@Id
                                      @GeneratedValue
                                      UUID id,
                                      String sequenceType,
                                      Long nextSequenceNumber,
                                      LocalDateTime createdAt,
                                      LocalDateTime updatedAt
) {
}
