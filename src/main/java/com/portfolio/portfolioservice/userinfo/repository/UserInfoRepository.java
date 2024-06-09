package com.portfolio.portfolioservice.userinfo.repository;

import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfo, UUID>, JpaSpecificationExecutor<UserInfo> {

    Optional<UserInfo> findBySerialId(String serialId);
}
