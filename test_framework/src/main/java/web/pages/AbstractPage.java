package web.pages;

import lombok.Getter;
import web.webdriver.IWebdriver;
import web.webdriver.SelenideDriver;

@Getter
public abstract class AbstractPage {
    private final IWebdriver webdriver = new SelenideDriver();
}
