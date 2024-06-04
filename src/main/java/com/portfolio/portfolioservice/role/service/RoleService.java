package com.portfolio.portfolioservice.role.service;

import com.portfolio.portfolioservice.role.model.request.CreateRoleRequest;
import com.portfolio.portfolioservice.role.model.response.RoleResponse;

public interface RoleService {
    
    RoleResponse createRole(CreateRoleRequest request) throws Exception;

    RoleResponse getRoleById(String id);
}
