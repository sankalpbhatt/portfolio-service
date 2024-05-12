package com.portfolio.portfolioservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_info")
public class UserInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String serialId;
    private String firstName;
    private String lastName;
    private String phone;
    private String countryCode;
    private String email;
    private String imageUrl;
    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL)
    private Set<Address> addresses;
}
