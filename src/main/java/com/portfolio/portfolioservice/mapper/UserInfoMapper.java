package com.portfolio.portfolioservice.mapper;

import com.portfolio.portfolioservice.entity.UserInfo;
import com.portfolio.portfolioservice.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.model.response.UserInfoResponse;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper {

    public UserInfoResponse mapToResponse(UserInfo userInfo){
        return null;
    }

    public UserInfo mapToEntity(CreateUserRequest createUserRequest){
        new UserInfo();
        return null;
    }
}
