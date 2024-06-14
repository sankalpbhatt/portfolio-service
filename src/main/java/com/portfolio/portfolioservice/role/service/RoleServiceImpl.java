package com.portfolio.portfolioservice.role.service;

import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;
import com.portfolio.portfolioservice.industry.service.IndustryService;
import com.portfolio.portfolioservice.role.entity.Role;
import com.portfolio.portfolioservice.role.entity.sepcification.RoleSpecification;
import com.portfolio.portfolioservice.role.mapper.RoleMapper;
import com.portfolio.portfolioservice.role.model.request.CreateRoleRequest;
import com.portfolio.portfolioservice.role.model.request.RoleSearchCriteria;
import com.portfolio.portfolioservice.role.model.response.RolePageResponse;
import com.portfolio.portfolioservice.role.model.response.RoleResponse;
import com.portfolio.portfolioservice.role.repository.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;
    private final RoleRepository repository;
    private final IndustryService industryService;

    public RoleServiceImpl(RoleMapper roleMapper, RoleRepository repository, IndustryService industryService) {
        this.roleMapper = roleMapper;
        this.repository = repository;
        this.industryService = industryService;
    }

    @Override
    public RoleResponse createRole(CreateRoleRequest request) throws Exception {
        Role role = roleMapper.mapToEntity(request);
        role = repository.save(role);
        IndustryResponse industryResponse = industryService.getIndustryById(role.getIndustryId());
        return roleMapper.mapToResponse(role, industryResponse);
    }

    @Override
    public RoleResponse getRoleById(String id) {
        Role role = repository.findBySerialId(id).orElseThrow();
        IndustryResponse industryResponse = industryService.getIndustryById(role.getIndustryId());
        return roleMapper.mapToResponse(role, industryResponse);
    }

    @Override
    public RolePageResponse searchCriteria(RoleSearchCriteria searchCriteria) {
        Pageable pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getSize());
        Page<Role> roles = repository
                .findAll(RoleSpecification.getRoleByCriteria(searchCriteria), pageable);
        return roleMapper.mapToResponse(roles);
    }
}
