package com.portfolio.portfolioservice.repository;

import com.portfolio.portfolioservice.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {
}
