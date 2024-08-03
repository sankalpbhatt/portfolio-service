/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.userinfo.model.request;

import com.portfolio.portfolioservice.address.model.request.AddressRequest;
import com.portfolio.portfolioservice.userinfo.validation.ValidUserInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@ValidUserInfo
public record CreateUserRequest(
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull @Schema(example = "91") String countryCode,
        @NotNull @Schema(example = "9087654321") String phone,
        @NotNull @Schema(example = "sample@onemail.com") String email,
        String imageUrl,
        List<AddressRequest> addresses) {
}
