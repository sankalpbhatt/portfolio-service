package com.portfolio.portfolioservice.userinfo.validation;

import com.portfolio.portfolioservice.userinfo.model.request.CreateUserRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoValidator implements ConstraintValidator<ValidUserInfo, CreateUserRequest> {

    private static final String EMAIL_REGEX = "^(.+)@(.+)$";

    private String message;

    public UserInfoValidator() {
    }

    @Override
    public void initialize(ValidUserInfo constraintAnnotation) {
        // DO nothing here
    }

    @Override
    public boolean isValid(final CreateUserRequest value, final ConstraintValidatorContext context) {
        if (invalidPhone(value)) return false;
        if (invalidCountryCode(value)) return false;
        if (invalidEmail(value)) return false;
        return true;
    }

    /**
     * Validates email using regex ^(.+)@(.+)$.
     *
     * @param value
     * @return
     */
    private boolean invalidEmail(CreateUserRequest value) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(value.email());
        if (!matcher.matches()) {
            message = "Invalid email";
            return true;
        }
        return false;
    }

    /**
     * Validates phone length. Should not be less than 10.
     *
     * @param value
     * @return
     */
    private boolean invalidPhone(CreateUserRequest value) {
        if (value.phone().length() < 10) {
            message = "Invalid phone";
            return true;
        }
        return false;
    }

    /**
     * Validates country code. Length should not be less than 2.
     *
     * @param value
     * @return
     */
    private boolean invalidCountryCode(CreateUserRequest value) {
        if (value.countryCode().length() < 2) {
            message = "Invalid country codes";
            return true;
        }
        return false;
    }
}
