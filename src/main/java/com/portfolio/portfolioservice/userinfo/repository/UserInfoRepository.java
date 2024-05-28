package com.portfolio.portfolioservice.userinfo.repository;

import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {

    Optional<UserInfo> findBySerialId(String serialId);
}
