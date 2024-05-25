package com.portfolio.portfolioservice.theme.entity;

import com.portfolio.portfolioservice.common.entity.BaseDeletableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "theme", schema = "portfolio")
public class Theme extends BaseDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String serialId;
    private String name;
    private String description;
    private Integer textColor;
    private Integer backgroundColor;
    private Integer primaryColor;
    private Integer secondaryColor;
    private String font;
    private Integer fontSize;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTextColor() {
        return textColor;
    }

    public void setTextColor(Integer textColor) {
        this.textColor = textColor;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Integer getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Integer primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Integer getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Integer secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }
}
