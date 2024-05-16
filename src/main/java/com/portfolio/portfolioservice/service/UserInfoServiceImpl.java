package com.portfolio.portfolioservice.service;

import com.portfolio.portfolioservice.entity.UserInfo;
import com.portfolio.portfolioservice.mapper.UserInfoMapper;
import com.portfolio.portfolioservice.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.model.response.UserInfoResponse;
import com.portfolio.portfolioservice.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserInfoMapper userInfoMapper;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository, UserInfoMapper userInfoMapper) {
        this.userInfoRepository = userInfoRepository;
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfoResponse createUserInfo(CreateUserRequest createUserRequest){
        UserInfo userInfo = userInfoMapper.mapToEntity(createUserRequest);
        userInfo = userInfoRepository.save(userInfo);
        return userInfoMapper.mapToResponse(userInfo);
    }

    @Override
    public UserInfoResponse getUserInfo(CreateUserRequest createUserRequest){
        UserInfo userInfo = userInfoMapper.mapToEntity(createUserRequest);
        userInfo = userInfoRepository.save(userInfo);
        return userInfoMapper.mapToResponse(userInfo);
    }

}
