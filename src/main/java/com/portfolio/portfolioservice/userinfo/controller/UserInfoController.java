package com.portfolio.portfolioservice.userinfo.controller;

import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import com.portfolio.portfolioservice.userinfo.model.response.UserInfoResponse;
import com.portfolio.portfolioservice.userinfo.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/user-info")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping
    @Operation(summary = "Create User Info")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(description = "API to create UserInfo")
    public UserInfoResponse createUserInfo(@Valid @RequestBody CreateUserRequest createUserRequest) throws Exception {
        return userInfoService.createUserInfo(createUserRequest);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get User Info by ID")
    @ApiResponse(description = "API to get UserInfo by ID")
    public UserInfoResponse getUserInfo(@PathVariable(name = "id") String id) throws Exception {
        return userInfoService.getUserInfo(id);
    }
}
