package com.portfolio.portfolioservice.userinfo.controller;

import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;
import com.portfolio.portfolioservice.userinfo.service.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService){
        this.userInfoService = userInfoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserInfoResponse createUserInfo(CreateUserRequest createUserRequest){
        return userInfoService.createUserInfo(createUserRequest);
    }
}
