/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.entity;

import com.portfolio.portfolioservice.common.entity.BaseDeletableEntity;
import com.portfolio.portfolioservice.template.enitity.Template;
import com.portfolio.portfolioservice.theme.model.request.PropertySet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;

    @Column(columnDefinition = "jsonb")
    private PropertySet text;

    @Column(columnDefinition = "jsonb")
    private PropertySet background;

    @Column(columnDefinition = "jsonb")
    private PropertySet button;

    @Column(columnDefinition = "jsonb")
    private PropertySet border;

    @Column(columnDefinition = "jsonb")
    private PropertySet font;

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

    public PropertySet getText() {
        return text;
    }

    public void setText(PropertySet text) {
        this.text = text;
    }

    public PropertySet getBackground() {
        return background;
    }

    public void setBackground(PropertySet background) {
        this.background = background;
    }

    public PropertySet getButton() {
        return button;
    }

    public void setButton(PropertySet button) {
        this.button = button;
    }

    public PropertySet getBorder() {
        return border;
    }

    public void setBorder(PropertySet border) {
        this.border = border;
    }

    public PropertySet getFont() {
        return font;
    }

    public void setFont(PropertySet font) {
        this.font = font;
    }
}
