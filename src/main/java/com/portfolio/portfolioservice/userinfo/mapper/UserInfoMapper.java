package com.portfolio.portfolioservice.userinfo.mapper;

import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;
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
