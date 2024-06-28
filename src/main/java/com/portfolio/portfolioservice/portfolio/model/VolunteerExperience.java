package com.portfolio.portfolioservice.portfolio.model;

import java.time.LocalDate;

public class VolunteerExperience {

  private String organizationName;
  private String volunteerRole;
  private LocalDate startDate;
  private LocalDate endDate;
  private String description;

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public String getVolunteerRole() {
    return volunteerRole;
  }

  public void setVolunteerRole(String volunteerRole) {
    this.volunteerRole = volunteerRole;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
