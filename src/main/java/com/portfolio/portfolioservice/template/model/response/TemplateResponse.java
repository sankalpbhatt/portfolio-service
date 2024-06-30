/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.template.model.response;

public class TemplateResponse {

  private String id;
  private String name;
  private String description;
  private String layout;

  public TemplateResponse() {}

  public TemplateResponse(String id, String name, String description, String layout) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.layout = layout;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getLayout() {
    return layout;
  }

  public void setLayout(String layout) {
    this.layout = layout;
  }
}
