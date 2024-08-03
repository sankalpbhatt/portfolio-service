/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.common.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class StringFilter {

    @Schema(example = "value")
    private String value;
    private Operation operation;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public enum Operation {
        CONTAINS,
        EQUALS,
        STARTS_WITH,
        ENDS_WITH
    }
}
