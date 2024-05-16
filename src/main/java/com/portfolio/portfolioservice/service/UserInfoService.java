package com.portfolio.portfolioservice.service;

import com.portfolio.portfolioservice.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.model.response.UserInfoResponse;

public interface UserInfoService {
    UserInfoResponse createUserInfo(CreateUserRequest createUserRequest);
    UserInfoResponse getUserInfo(CreateUserRequest createUserRequest);
}
