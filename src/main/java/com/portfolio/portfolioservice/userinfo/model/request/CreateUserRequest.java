package com.portfolio.portfolioservice.userinfo.model.request;

import com.portfolio.portfolioservice.address.model.request.AddressRequest;

import java.util.List;

public class CreateUserRequest{

    private final String firstName;
    private final String lastName;
    private final String countryCode;
    private final String phone;
    private final String email;
    private final String imageUrl;
    private final List<AddressRequest> addresses;

    public CreateUserRequest(
            String firstName,
            String lastName,
            String countryCode,
            String phone,
            String email,
            String imageUrl,
            List<AddressRequest> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
        this.phone = phone;
        this.email = email;
        this.imageUrl = imageUrl;
        this.addresses = addresses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public List<AddressRequest> getAddresses() {
        return addresses;
    }
}
