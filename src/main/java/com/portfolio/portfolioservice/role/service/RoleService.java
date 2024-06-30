/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.role.service;

import com.portfolio.portfolioservice.role.model.request.CreateRoleRequest;
import com.portfolio.portfolioservice.role.model.request.RoleSearchCriteria;
import com.portfolio.portfolioservice.role.model.response.RolePageResponse;
import com.portfolio.portfolioservice.role.model.response.RoleResponse;

public interface RoleService {

  RoleResponse createRole(CreateRoleRequest request) throws Exception;

  RoleResponse getRoleById(String id);

  RolePageResponse searchCriteria(RoleSearchCriteria searchCriteria);
}
