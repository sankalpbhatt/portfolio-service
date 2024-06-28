package com.portfolio.portfolioservice.common.model.request;

public class StringFilter {

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
