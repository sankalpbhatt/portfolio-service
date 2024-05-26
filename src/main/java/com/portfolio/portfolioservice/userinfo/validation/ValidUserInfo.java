package com.portfolio.portfolioservice.userinfo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = UserInfoValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface ValidUserInfo {

    String message() default "The password does not comply with the rules.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
