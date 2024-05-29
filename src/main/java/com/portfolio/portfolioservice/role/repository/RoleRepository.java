package com.portfolio.portfolioservice.role.repository;

import com.portfolio.portfolioservice.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
