package com.portfolio.portfolioservice.userinfo.mapper;

import com.portfolio.portfolioservice.address.mapper.AddressMapper;
import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper {

    private final AddressMapper addressMapper;

    public UserInfoMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public UserInfoResponse mapToResponse(UserInfo userInfo){
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

    public UserInfo mapToEntity(CreateUserRequest createUserRequest){

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(createUserRequest.getFirstName());
        userInfo.setLastName(createUserRequest.getFirstName());
        userInfo.setPhone(createUserRequest.getCountryCode()+createUserRequest.getPhone());
        userInfo.setEmail(createUserRequest.getEmail());
        userInfo.setImageUrl(createUserRequest.getImageUrl());
        userInfo.setAddresses(addressMapper.mapToEntity(createUserRequest.getAddresses()));
        return userInfo;
    }
}
