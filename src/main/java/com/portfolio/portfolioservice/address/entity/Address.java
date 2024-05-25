package com.portfolio.portfolioservice.address.entity;

import com.portfolio.portfolioservice.common.entity.BaseDeletableEntity;
import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table( name = "address" )
public class Address extends BaseDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String serialId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String region;
    private String country;
    private String postalCode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
}
