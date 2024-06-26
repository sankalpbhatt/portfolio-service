/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.model.request;

import com.portfolio.portfolioservice.common.model.request.StringFilter;

public class ThemeSearchCriteria {

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
    if (size == 0) {
      return 1;
    }
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
