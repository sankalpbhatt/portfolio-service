package com.portfolio.portfolioservice.common.model.request;

public class StringFilter {

    private String value;
    private Operation operation;

    public enum Operation {
        CONTAINS,
        EQUALS,
        STARTS_WITH
    }

}
