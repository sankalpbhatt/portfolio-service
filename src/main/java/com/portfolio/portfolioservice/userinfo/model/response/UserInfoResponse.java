/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.userinfo.model.response;

import java.util.Set;

import com.portfolio.portfolioservice.address.model.response.AddressResponse;

public class UserInfoResponse {

  private String id;
  private String firstName;
  private String lastName;
  private String phone;
  private String email;
  private String imageUrl;
  private Set<AddressResponse> addresses;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Set<AddressResponse> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<AddressResponse> addresses) {
    this.addresses = addresses;
  }
}
