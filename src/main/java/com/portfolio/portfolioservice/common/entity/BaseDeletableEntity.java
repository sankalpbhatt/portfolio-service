/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.common.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseDeletableEntity {

  protected LocalDateTime createdAt = LocalDateTime.now();
  protected LocalDateTime updatedAt = LocalDateTime.now();
  protected LocalDateTime deletedAt = LocalDateTime.now();

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

  public LocalDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(LocalDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }
}
