package com.portfolio.portfolioservice.service;

import com.portfolio.portfolioservice.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.model.response.UserInfoResponse;
import com.portfolio.portfolioservice.repository.UserInfoRepository;

public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserInfoResponse createUser(CreateUserRequest createUserRequest){
        return null;
    }
}
