package com.portfolio.portfolioservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "portfolio")
public record Portfolio(@Id
                        UUID id,
                        String serialId,
                        UUID themeId
){}