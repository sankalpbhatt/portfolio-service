/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.address.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class AddressRequest {

    @Schema(example = "H No 1")
    private String addressLine1;
    @Schema(example = "Andheri")
    private String addressLine2;
    @Schema(example = "Mumbai")
    private String city;
    @Schema(example = "Maharashtra")
    private String region;
    @Schema(example = "India")
    private String country;
    @Schema(example = "400093")
    private String postalCode;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
