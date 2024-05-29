package com.portfolio.portfolioservice.role.entity;

import com.portfolio.portfolioservice.common.entity.BaseDeletableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "role", schema = "portfolio")
public class Role extends BaseDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String serialId;
    private String name;
    private UUID industryId;
    private String imageUrl;

    public UUID getId() {
        return id;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getIndustryId() {
        return industryId;
    }

    public void setIndustryId(UUID industryId) {
        this.industryId = industryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
