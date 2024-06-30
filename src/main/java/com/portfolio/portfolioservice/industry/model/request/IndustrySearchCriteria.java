/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.industry.model.request;

import com.portfolio.portfolioservice.common.model.request.StringFilter;

import io.swagger.v3.oas.annotations.media.Schema;

public class IndustrySearchCriteria {

  @Schema(description = "Pass the search key in StringFilter")
  private StringFilter name;

  private int page;
  private int size;

  public StringFilter getName() {
    return name;
  }

  public void setName(StringFilter name) {
    this.name = name;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size == 0 ? 20 : size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
