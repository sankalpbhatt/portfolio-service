package com.portfolio.portfolioservice.userinfo.service;

import com.portfolio.portfolioservice.common.service.SequenceService;
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
    private final SequenceService sequenceService;

    public UserInfoServiceImpl(
            UserInfoRepository userInfoRepository,
            UserInfoMapper userInfoMapper,
            SequenceService sequenceService) {
        this.userInfoRepository = userInfoRepository;
        this.userInfoMapper = userInfoMapper;
        this.sequenceService = sequenceService;
    }

    @Override
    public UserInfoResponse createUserInfo(CreateUserRequest createUserRequest) throws Exception {
        UserInfo userInfo = userInfoMapper.mapToEntity(createUserRequest);
        userInfo = userInfoRepository.save(userInfo);
        return userInfoMapper.mapToResponse(userInfo);
    }

    @Override
    public UserInfoResponse getUserInfoById(String id) throws Exception {
        UserInfo userInfo = userInfoRepository.findBySerialId(id).orElseThrow(() -> new Exception());
        return userInfoMapper.mapToResponse(userInfo);
    }
}
