package com.portfolio.portfolioservice.industry.entity;

import java.util.UUID;

import com.portfolio.portfolioservice.common.entity.BaseDeletableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "industries", schema = "portfolio")
public class Industry extends BaseDeletableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String serialId;

  @JoinColumn(name = "parent_industry_id")
  @OneToOne
  private Industry parentIndustry;

  private String imageUrl;

  @Column(nullable = false)
  private String industryName;

  public UUID getId() {
    return id;
  }

  public String getSerialId() {
    return serialId;
  }

  public void setSerialId(String serialId) {
    this.serialId = serialId;
  }

  public String getIndustryName() {
    return industryName;
  }

  public void setIndustryName(String industryName) {
    this.industryName = industryName;
  }

  public Industry getParentIndustry() {
    return parentIndustry;
  }

  public void setParentIndustry(Industry parentIndustry) {
    this.parentIndustry = parentIndustry;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
