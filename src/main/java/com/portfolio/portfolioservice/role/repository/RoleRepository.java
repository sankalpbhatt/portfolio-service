/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.role.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.portfolio.portfolioservice.role.entity.Role;

public interface RoleRepository extends JpaRepository<Role, UUID>, JpaSpecificationExecutor<Role> {

  Optional<Role> findBySerialId(String serialId);
}
