package com.portfolio.portfolioservice.role.mapper;

import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.industry.model.response.IndustryResponse;
import com.portfolio.portfolioservice.role.entity.Role;
import com.portfolio.portfolioservice.role.model.request.CreateRoleRequest;
import com.portfolio.portfolioservice.role.model.response.RoleResponse;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final SequenceService sequenceService;

    public RoleMapper(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    public Role mapToEntity(CreateRoleRequest request) throws Exception {
        Role role = new Role();
        role.setImageUrl(request.getImageUrl());
        role.setName(request.getName());
        role.setSerialId(SequenceService.SequenceType.ROLE.getPrefix()
                + sequenceService.getNextSequenceNumber(SequenceService.SequenceType.ROLE));
        return role;
    }

    public RoleResponse mapToResponse(Role role, IndustryResponse industryResponse) {
        RoleResponse response = new RoleResponse();
        response.setId(role.getSerialId());
        response.setName(role.getName());
        response.setImageUrl(role.getImageUrl());
        response.setIndustry(industryResponse);
        return response;
    }
}
