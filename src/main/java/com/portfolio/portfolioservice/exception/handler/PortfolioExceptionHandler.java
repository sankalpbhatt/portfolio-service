package com.portfolio.portfolioservice.exception.handler;

import com.portfolio.portfolioservice.exception.PortfolioException;
import com.portfolio.portfolioservice.exception.model.ErrorCode;
import com.portfolio.portfolioservice.exception.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PortfolioExceptionHandler {

    @ExceptionHandler(PortfolioException.class)
    public ResponseEntity<ErrorResponse> handlePortfolioException(PortfolioException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, getStatusFromErrorCode(ex.getErrorCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.GENERAL.getCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static HttpStatus getStatusFromErrorCode(ErrorCode code) {
        return switch (code) {
            case BUSINESS_ERROR -> HttpStatus.BAD_REQUEST;
            case PERMISSION -> HttpStatus.FORBIDDEN;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
    }
}
