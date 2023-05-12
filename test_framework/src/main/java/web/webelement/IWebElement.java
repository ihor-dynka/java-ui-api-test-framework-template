package web.webelement;

import java.io.File;
import java.time.Duration;

public interface IWebElement {

    String getText();

    String getTitle();

    IWebElement setInputValue(String value);

    IWebElement click();

    IWebElement clear();

    boolean hasText(String text);

    IWebElement shouldHaveExactText(String exactText);

    IWebElement shouldHaveExactText(String exactText, Duration duration);

    IWebElement shouldHaveText(String exactText);

    IWebElement shouldHaveText(String exactText, Duration duration);

    IWebElement shouldNotHaveText(String exactText);

    IWebElement shouldNotHaveText(String exactText, Duration duration);

    IWebElement shouldHaveTitle(String title);

    void shouldHaveTitle(String employee, Duration duration);

    IWebElement shouldNotHaveTitle(String title);

    IWebElement shouldHaveAttribute(String attribute, String value);

    IWebElement shouldNotHaveAttribute(String attributeName);

    IWebElement shouldHaveValue(String value);

    IWebElement shouldAppears();

    IWebElement shouldAppears(Duration duration);

    IWebElement shouldDisappears();

    IWebElement shouldDisappears(Duration duration);

    IWebElement shouldBeDisabled();

    IWebElement findByClass(String className);

    IWebElement findByCss(String selector);

    IWebElement findByXpath(String xpath);

    IWebElement findByTitle(String title);

    IWebElement findByText(String text);

    boolean isChecked();

    IWebElement scrollIntoViewTop();

    IWebElement scrollIntoViewBottom();

    IWebElements findAllByCss(String selector);

    IWebElement shouldBeImage();

    File downloadFileWithExtension(String extension);

    IWebElement closest(String selector);

    IWebElement sendKeys(CharSequence... keysToSend);

    IWebElement shouldHaveClass(String className);

    boolean hasClass(String className);

    IWebElement shouldBeEnabled();

    boolean isVisible();

    boolean isExists();

    boolean hasAttribute(String attributeName);

    boolean hasAttribute(String attributeName, String attributeValue);
}
