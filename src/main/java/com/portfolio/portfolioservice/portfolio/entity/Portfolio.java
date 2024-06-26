/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.portfolio.entity;

import java.util.UUID;

import com.portfolio.portfolioservice.common.entity.BaseDeletableEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio", schema = "portfolio")
public class Portfolio extends BaseDeletableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String description;
  private String bio;
  private String serialId;
  private UUID userInfoId;
  private UUID themeId;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getSerialId() {
    return serialId;
  }

  public void setSerialId(String serialId) {
    this.serialId = serialId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public UUID getUserInfoId() {
    return userInfoId;
  }

  public void setUserInfoId(UUID userInfoId) {
    this.userInfoId = userInfoId;
  }

  public UUID getThemeId() {
    return themeId;
  }

  public void setThemeId(UUID themeId) {
    this.themeId = themeId;
  }
}
