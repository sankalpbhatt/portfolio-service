package com.portfolio.portfolioservice.userinfo.service;

import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;

public interface UserInfoService {

    UserInfoResponse createUserInfo(CreateUserRequest createUserRequest);

    UserInfoResponse getUserInfo(String id) throws Exception;
}
