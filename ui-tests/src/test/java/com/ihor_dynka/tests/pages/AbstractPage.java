package com.ihor_dynka.tests.pages;

import lombok.Getter;
import lombok.SneakyThrows;
import web.webdriver.IWebdriver;
import web.webdriver.SelenideDriver;

@Getter
public abstract class AbstractPage {

    private final IWebdriver webdriver = new SelenideDriver();

    @SneakyThrows
    public <Page> Page onNewTab(Class<Page> page) {
        getWebdriver().openNewTab();
        getWebdriver().switchToWindow(1);
        return page.newInstance();
    }

    @SneakyThrows
    public <Page> Page backToPreviousTab(Class<Page> page) {
        getWebdriver().switchToWindow(0);
        return page.newInstance();
    }
}
