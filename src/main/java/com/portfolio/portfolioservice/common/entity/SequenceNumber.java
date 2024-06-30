/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.common.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.portfolio.portfolioservice.common.service.SequenceService;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sequence_numbers", schema = "portfolio")
public class SequenceNumber {
  @Id @GeneratedValue private UUID id;

  @Enumerated(EnumType.STRING)
  private SequenceService.SequenceType sequenceType;

  private Long nextSequenceNumber;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public SequenceService.SequenceType getSequenceType() {
    return sequenceType;
  }

  public void setSequenceType(SequenceService.SequenceType sequenceType) {
    this.sequenceType = sequenceType;
  }

  public Long getNextSequenceNumber() {
    return nextSequenceNumber;
  }

  public void setNextSequenceNumber(Long nextSequenceNumber) {
    this.nextSequenceNumber = nextSequenceNumber;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
