/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.userinfo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.portfolioservice.userinfo.entity.UserInfo;

public interface UserInfoRepository
    extends JpaRepository<UserInfo, UUID>, JpaSpecificationExecutor<UserInfo> {

  Optional<UserInfo> findBySerialId(String serialId);

  @Query(
      value = "SELECT id FROM portfolio.user_info WHERE serial_id = :serialId",
      nativeQuery = true)
  Optional<UUID> findIdBySerialId(String serialId);
}
