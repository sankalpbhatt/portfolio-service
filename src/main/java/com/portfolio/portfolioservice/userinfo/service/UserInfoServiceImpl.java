/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.userinfo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import com.portfolio.portfolioservice.userinfo.entity.speicification.UserInfoSpecification;
import com.portfolio.portfolioservice.userinfo.mapper.UserInfoMapper;
import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.request.UserInfoSearchCriteria;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoPageResponse;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;
import com.portfolio.portfolioservice.userinfo.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {

  private final UserInfoRepository userInfoRepository;
  private final UserInfoMapper userInfoMapper;

  public UserInfoServiceImpl(UserInfoRepository userInfoRepository, UserInfoMapper userInfoMapper) {
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

  @Override
  public UserInfoPageResponse searchUserInfo(UserInfoSearchCriteria searchCriteria) {
    Pageable pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getSize());
    Page<UserInfo> userInfoPage =
        userInfoRepository.findAll(
            UserInfoSpecification.getUserInfoBySpecification(searchCriteria), pageable);
    return userInfoMapper.mapToResponse(userInfoPage);
  }
}
