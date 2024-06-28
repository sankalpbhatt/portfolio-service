package com.portfolio.portfolioservice.portfolio.model.request;

public class AddPortfolioDetailsRequest<T> {

  private T t;
  private String roleId;

  public T getT() {
    return t;
  }

  public void setT(T t) {
    this.t = t;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }
}
