package com.portfolio.portfolioservice.portfolio.model;

import java.time.LocalDate;

public class Award {

    private String awardTitle;
    private String awardingOrganization;
    private LocalDate dateReceived;

    public String getAwardTitle() {
        return awardTitle;
    }

    public void setAwardTitle(String awardTitle) {
        this.awardTitle = awardTitle;
    }

    public String getAwardingOrganization() {
        return awardingOrganization;
    }

    public void setAwardingOrganization(String awardingOrganization) {
        this.awardingOrganization = awardingOrganization;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }
}
