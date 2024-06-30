/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.userinfo.model.request;

import java.util.List;

import com.portfolio.portfolioservice.address.model.request.AddressRequest;
import com.portfolio.portfolioservice.userinfo.validation.ValidUserInfo;

import jakarta.validation.constraints.NotNull;

@ValidUserInfo
public record CreateUserRequest(
    @NotNull String firstName,
    @NotNull String lastName,
    @NotNull String countryCode,
    @NotNull String phone,
    @NotNull String email,
    String imageUrl,
    List<AddressRequest> addresses) {}
