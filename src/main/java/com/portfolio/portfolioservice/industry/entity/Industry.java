package com.portfolio.portfolioservice.industry.entity;

import com.portfolio.portfolioservice.common.entity.BaseDeletableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "industry", schema = "portfolio")
public class Industry extends BaseDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String serialId;
    private String industryName;
    private UUID parentIndustryId;
    private String imageUrl;
}
