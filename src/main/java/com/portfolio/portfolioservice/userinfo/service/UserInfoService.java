package com.portfolio.portfolioservice.userinfo.service;

import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.request.UserInfoSearchCriteria;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoPageResponse;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;

public interface UserInfoService {

    UserInfoResponse createUserInfo(CreateUserRequest createUserRequest) throws Exception;

    UserInfoResponse getUserInfoById(String id) throws Exception;

    UserInfoPageResponse searchUserInfo(UserInfoSearchCriteria searchCriteria);
}
