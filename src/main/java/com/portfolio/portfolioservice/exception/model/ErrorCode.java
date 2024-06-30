/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.exception.model;

public enum ErrorCode {
  GENERAL("PF0001", "General Error"),
  BUSINESS_ERROR("PF0002", "Business Error"),
  PERMISSION("PF0003", "Permission Issue");

  private final String code;
  private final String message;

  ErrorCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
