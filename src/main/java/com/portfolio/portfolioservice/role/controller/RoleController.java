/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.role.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portfolioservice.role.model.request.CreateRoleRequest;
import com.portfolio.portfolioservice.role.model.request.RoleSearchCriteria;
import com.portfolio.portfolioservice.role.model.response.RolePageResponse;
import com.portfolio.portfolioservice.role.model.response.RoleResponse;
import com.portfolio.portfolioservice.role.service.RoleService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/role")
@Validated
public class RoleController {

  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping
  @Operation(summary = "Create Role")
  @ResponseStatus(HttpStatus.CREATED)
  public RoleResponse createRole(@RequestBody @Valid CreateRoleRequest request) throws Exception {
    return roleService.createRole(request);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get Role by ID")
  public RoleResponse getRole(@PathVariable("id") @NotNull String id) {
    return roleService.getRoleById(id);
  }

  @GetMapping
  public RolePageResponse searchRole(@ParameterObject RoleSearchCriteria searchCriteria) {
    return roleService.searchCriteria(searchCriteria);
  }
}
