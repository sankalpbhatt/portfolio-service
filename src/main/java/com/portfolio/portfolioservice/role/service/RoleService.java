package com.portfolio.portfolioservice.role.service;

import com.portfolio.portfolioservice.role.model.request.CreateRoleRequest;
import com.portfolio.portfolioservice.role.model.response.RoleResponse;

public interface RoleService {
    RoleResponse createRole(CreateRoleRequest request);

    RoleResponse getRoleById(String id);
}
