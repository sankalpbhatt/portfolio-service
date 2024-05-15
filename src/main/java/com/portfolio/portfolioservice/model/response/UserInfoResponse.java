package com.portfolio.portfolioservice.model.response;

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
