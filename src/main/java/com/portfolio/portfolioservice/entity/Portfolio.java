package com.portfolio.portfolioservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Portfolio {

    @Id
    private UUID id;
    private String serialId;
    private UUID themeId;

}
