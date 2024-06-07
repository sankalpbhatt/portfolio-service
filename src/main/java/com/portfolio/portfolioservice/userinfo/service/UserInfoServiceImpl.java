package com.portfolio.portfolioservice.userinfo.service;

import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import com.portfolio.portfolioservice.userinfo.mapper.UserInfoMapper;
import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;
import com.portfolio.portfolioservice.userinfo.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserInfoMapper userInfoMapper;

    public UserInfoServiceImpl(
            UserInfoRepository userInfoRepository,
            UserInfoMapper userInfoMapper) {
        this.userInfoRepository = userInfoRepository;
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfoResponse createUserInfo(CreateUserRequest createUserRequest) throws Exception {
        UserInfo userInfo = userInfoMapper.mapToEntity(createUserRequest);
        userInfo = userInfoRepository.save(userInfo);
        return userInfoMapper.mapToResponse(userInfo);
    }

    @Override
    public UserInfoResponse getUserInfoById(String id) {
        UserInfo userInfo = userInfoRepository.findBySerialId(id).orElseThrow();
        return userInfoMapper.mapToResponse(userInfo);
    }
}
