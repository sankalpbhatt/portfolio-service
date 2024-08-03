/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.entity;

import java.util.UUID;

import org.hibernate.annotations.ColumnTransformer;

import com.portfolio.portfolioservice.common.entity.BaseDeletableEntity;
import com.portfolio.portfolioservice.template.enitity.Template;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "theme", schema = "portfolio")
public class Theme extends BaseDeletableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String serialId;
  private String name;
  private String description;

  @ManyToOne
  @JoinColumn(name = "template_id", nullable = false)
  private Template template;

  @ColumnTransformer(write = "?::jsonb")
  private String text;

  @ColumnTransformer(write = "?::jsonb")
  private String background;

  @ColumnTransformer(write = "?::jsonb")
  private String button;

  @ColumnTransformer(write = "?::jsonb")
  private String border;

  @ColumnTransformer(write = "?::jsonb")
  private String font;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Template getTemplate() {
    return template;
  }

  public void setTemplate(Template template) {
    this.template = template;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getBackground() {
    return background;
  }

  public void setBackground(String background) {
    this.background = background;
  }

  public String getButton() {
    return button;
  }

  public void setButton(String button) {
    this.button = button;
  }

  public String getBorder() {
    return border;
  }

  public void setBorder(String border) {
    this.border = border;
  }

  public String getFont() {
    return font;
  }

  public void setFont(String font) {
    this.font = font;
  }
}
