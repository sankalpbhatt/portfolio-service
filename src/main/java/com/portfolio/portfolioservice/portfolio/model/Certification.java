package com.portfolio.portfolioservice.portfolio.model;

import java.time.LocalDate;

public class Certification {

  private String certificationName;
  private String issuingOrganization;
  private LocalDate certificationDate;

  public String getCertificationName() {
    return certificationName;
  }

  public void setCertificationName(String certificationName) {
    this.certificationName = certificationName;
  }

  public String getIssuingOrganization() {
    return issuingOrganization;
  }

  public void setIssuingOrganization(String issuingOrganization) {
    this.issuingOrganization = issuingOrganization;
  }

  public LocalDate getCertificationDate() {
    return certificationDate;
  }

  public void setCertificationDate(LocalDate certificationDate) {
    this.certificationDate = certificationDate;
  }
}
