package com.portfolio.portfolioservice.userinfo.model.request;

import com.portfolio.portfolioservice.common.model.request.StringFilter;

public class UserInfoSearchCriteria {

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
