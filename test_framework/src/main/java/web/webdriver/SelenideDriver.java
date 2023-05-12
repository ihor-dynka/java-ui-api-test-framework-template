package web.webdriver;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.By;
import web.webelement.IWebElement;
import web.webelement.IWebElements;
import web.webelement.SelenideWebElement;
import web.webelement.SelenideWebElements;

import java.time.Duration;

public class SelenideDriver implements IWebdriver {

    private IWebElement webElement;

    @Override
    public void closeWebdriver() {
        WebDriverRunner.closeWebDriver();
    }

    @Override
    public void switchToWindow(String title) {
        Selenide.switchTo().window(title);
    }

    @Override
    public void switchToWindow(int defaultIndex) {
        Selenide.switchTo().window(defaultIndex);
    }

    @Override
    public SelenideDriver setBrowser(String browser) {
        Configuration.browser = browser;
        return this;
    }

    @Override
    public IWebdriver setBrowserSize(String size) {
        Configuration.browserSize = size;
        return this;
    }

    @Override
    public SelenideDriver setTimeout(long timeout) {
        Configuration.timeout = timeout;
        return this;
    }

    @Override
    public SelenideDriver setBaseUrl(String baseUrl) {
        Configuration.baseUrl = baseUrl;
        return this;
    }

    @Override
    public SelenideDriver setDownloadFilePath(String downloadFilePath) {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.downloadsFolder = "build/selenide/downloads/";
        return this;
    }

    @Override
    public SelenideDriver setRemoteUrl(String url) {
        Configuration.remote = url;
        return this;
    }

    @Override
    public SelenideDriver setHeadlessMode(boolean headlessMode) {
        Configuration.headless = headlessMode;
        return this;
    }

    @Override
    public IWebdriver setDriverManagerEnabled(boolean driverManagerEnabled) {
        Configuration.driverManagerEnabled = driverManagerEnabled;
        return this;
    }

    @Override
    public IWebdriver sleep(Duration duration) {
        Selenide.sleep(duration.toMillis());
        return this;
    }

    @Override
    public IWebdriver open(String url) {
        Selenide.open(url);
        return this;
    }

    @Override
    public IWebElement getElementById(String id) {
        this.webElement = new SelenideWebElement(By.id(id));
        return this.webElement;
    }

    @Override
    public IWebElement getElementByName(String name) {
        this.webElement = new SelenideWebElement(By.name(name));
        return this.webElement;
    }

    @Override
    public IWebElement getElementByCss(String selector) {
        this.webElement = new SelenideWebElement(By.cssSelector(selector));
        return this.webElement;
    }

    @Override
    public IWebElement getElementByXpath(String locator) {
        this.webElement = new SelenideWebElement(By.xpath(locator));
        return this.webElement;
    }

    @Override
    public IWebElement getElementByClass(String className) {
        this.webElement = new SelenideWebElement(By.className(className));
        return this.webElement;
    }

    @Override
    public IWebElement getElementByTitle(String title) {
        this.webElement = new SelenideWebElement(Selectors.byTitle(title));
        return this.webElement;
    }

    @Override
    public IWebElement getElementByTagName(String tagName) {
        this.webElement = new SelenideWebElement(By.tagName(tagName));
        return this.webElement;
    }

    @Override
    public IWebElement getElementByAttribute(String attributeName, String attributeValue) {
        this.webElement = new SelenideWebElement(Selectors.byAttribute(attributeName, attributeValue));
        return this.webElement;
    }

    @Override
    public IWebElement getElementByText(String text) {
        this.webElement = new SelenideWebElement(Selectors.byText(text));
        return this.webElement;
    }

    @Override
    public IWebElements getElementsByClass(String className) {
        return new SelenideWebElements(By.className(className));
    }

    @Override
    public IWebElements getElementsWithText(String text) {
        return new SelenideWebElements(Selectors.byText(text));
    }

    @Override
    public IWebElements getElementsByCss(String selector) {
        return new SelenideWebElements(By.cssSelector(selector));
    }

    @Override
    public IWebElements getElementsByAttribute(String attributeName, String attributeValue) {
        return new SelenideWebElements(Selectors.byAttribute(attributeName, attributeValue));
    }

    @Override
    public IWebElements getElementsByTitle(String title) {
        return new SelenideWebElements(Selectors.byTitle(title));
    }

    @Override
    public void logDriverEvents(boolean enable) {
        if (enable) SelenideLogger.addListener("Selenide Event Listener", new SelenideEventListener());
    }

    @Override
    public String getBrowserVersion() {
        return WebDriverRunner.driver().config().browserVersion();
    }

    @Override
    public String getBrowserSize() {
        return WebDriverRunner.driver().config().browserSize();
    }

    @Override
    public void openNewTab() {
        Selenide.executeJavaScript("window.open()");
    }

    @Override
    public void switchToDefaultContent() {
        Selenide.switchTo().defaultContent();
    }

    @Override
    public void switchToFrameByXpath(String xpath) {
        Selenide.switchTo().frame(Selenide.element(By.xpath(xpath)));
    }

    @Override
    public void switchToFrameByCss(String selector) {
        Selenide.switchTo().frame(Selenide.element(By.cssSelector(selector)));
    }
}
