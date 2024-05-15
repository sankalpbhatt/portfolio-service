package com.portfolio.portfolioservice.controller;

import com.portfolio.portfolioservice.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.model.response.UserInfoResponse;
import com.portfolio.portfolioservice.service.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService){
        this.userInfoService = userInfoService;

    }

    @PostMapping
    public UserInfoResponse createUserInfo(CreateUserRequest createUserRequest){
        return userInfoService.createUser(createUserRequest);

    }
}
