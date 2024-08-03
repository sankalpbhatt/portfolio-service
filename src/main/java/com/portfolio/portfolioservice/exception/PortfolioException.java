/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.exception;

import com.portfolio.portfolioservice.exception.model.ErrorCode;

public class PortfolioException extends RuntimeException {

  private final ErrorCode errorCode;

  public PortfolioException(String message, ErrorCode errorCode) {
    super(String.format(errorCode.getMessage(), message));
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}
