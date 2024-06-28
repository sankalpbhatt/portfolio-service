package com.portfolio.portfolioservice.userinfo.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.portfolio.portfolioservice.address.mapper.AddressMapper;
import com.portfolio.portfolioservice.common.service.SequenceService;
import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoPageResponse;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;

@Component
public class UserInfoMapper {

  private final AddressMapper addressMapper;
  private final SequenceService sequenceService;

  public UserInfoMapper(AddressMapper addressMapper, SequenceService sequenceService) {
    this.addressMapper = addressMapper;
    this.sequenceService = sequenceService;
  }

  public UserInfoResponse mapToResponse(UserInfo userInfo) {
    UserInfoResponse userInfoResponse = new UserInfoResponse();
    userInfoResponse.setId(userInfo.getSerialId());
    userInfoResponse.setFirstName(userInfo.getFirstName());
    userInfoResponse.setLastName(userInfo.getLastName());
    userInfoResponse.setEmail(userInfo.getEmail());
    userInfoResponse.setPhone(userInfo.getPhone());
    userInfoResponse.setImageUrl(userInfo.getImageUrl());
    userInfoResponse.setAddresses(addressMapper.mapToResponse(userInfo.getAddresses()));
    return null;
  }

  public UserInfo mapToEntity(CreateUserRequest createUserRequest) throws Exception {
    UserInfo userInfo = new UserInfo();
    userInfo.setSerialId(
        SequenceService.SequenceType.USERINFO.getPrefix()
            + sequenceService.getNextSequenceNumber(SequenceService.SequenceType.USERINFO));
    userInfo.setFirstName(createUserRequest.firstName());
    userInfo.setLastName(createUserRequest.lastName());
    userInfo.setPhone(createUserRequest.countryCode() + createUserRequest.phone());
    userInfo.setEmail(createUserRequest.email());
    userInfo.setImageUrl(createUserRequest.imageUrl());
    userInfo.setAddresses(addressMapper.mapToEntity(createUserRequest.addresses()));
    return userInfo;
  }

  public UserInfoPageResponse mapToResponse(Page<UserInfo> userInfoPage) {
    UserInfoPageResponse response = new UserInfoPageResponse();
    response.setContent(userInfoPage.stream().map(this::mapToResponse).toList());
    response.setPageNumber(userInfoPage.getNumber());
    response.setTotalElements(userInfoPage.getTotalElements());
    response.setPageSize(userInfoPage.getSize());
    response.setTotalPages(userInfoPage.getTotalPages());
    return response;
  }
}
