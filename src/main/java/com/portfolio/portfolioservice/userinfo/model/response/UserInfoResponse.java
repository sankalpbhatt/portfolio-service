package com.portfolio.portfolioservice.userinfo.model.response;

import com.portfolio.portfolioservice.address.model.response.AddressResponse;

import java.util.Set;
import java.util.UUID;

public record UserInfoResponse (
        UUID id,
        String serialId,
        String firstName,
        String lastName,
        String phone,
        String countryCode,
        String email,
        String imageUrl,
        Set<AddressResponse> addresses
){}
