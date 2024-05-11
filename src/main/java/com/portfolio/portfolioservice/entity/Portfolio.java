package com.portfolio.portfolioservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    private UUID id;
    private String serialId;
    private UUID themeId;

}
