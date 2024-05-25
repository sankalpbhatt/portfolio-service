package com.portfolio.portfolioservice.portfolio.model.request;

import com.portfolio.portfolioservice.userinfo.model.request.UserInfoRequest;

public record CreatePortfolioRequest(
        String themeId,
        UserInfoRequest userInfoRequest) { }
