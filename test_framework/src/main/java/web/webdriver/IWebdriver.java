package web.webdriver;

import web.webelement.IWebElement;
import web.webelement.IWebElements;

import java.time.Duration;

public interface IWebdriver {
    void closeWebdriver();

    void switchToWindow(String title);

    void switchToWindow(int defaultIndex);

    void switchToDefaultContent();

    void switchToFrameByXpath(String xpath);

    void switchToFrameByCss(String selector);

    IWebdriver setBrowser(String browser);

    IWebdriver setBrowserSize(String size);

    IWebdriver setTimeout(long timeout);

    IWebdriver setBaseUrl(String baseUrl);

    IWebdriver setDownloadFilePath(String downloadFilePath);

    IWebdriver setRemoteUrl(String url);

    IWebdriver setHeadlessMode(boolean headlessMode);

    IWebdriver setDriverManagerEnabled(boolean driverManagerEnabled);

    IWebdriver sleep(Duration duration);

    IWebdriver open(String url);

    IWebElement getElementById(String id);

    IWebElement getElementByName(String name);

    IWebElement getElementByCss(String selector);

    IWebElement getElementByXpath(String locator);

    IWebElement getElementByClass(String className);

    IWebElement getElementByTitle(String title);

    IWebElement getElementByTagName(String tagName);

    IWebElement getElementByAttribute(String attributeName, String attributeValue);

    IWebElement getElementByText(String text);

    IWebElements getElementsByClass(String className);

    IWebElements getElementsWithText(String text);

    IWebElements getElementsByCss(String selector);

    IWebElements getElementsByAttribute(String attributeName, String attributeValue);

    IWebElements getElementsByTitle(String title);

    void logDriverEvents(boolean enable);

    String getBrowserVersion();

    String getBrowserSize();

    void openNewTab();
}
