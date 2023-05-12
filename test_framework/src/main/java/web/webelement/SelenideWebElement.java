package web.webelement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.files.FileFilters.withExtension;

public class SelenideWebElement implements IWebElement {

    private final SelenideElement selenideWebElement;

    public SelenideWebElement(By by) {
        this.selenideWebElement = Selenide.element(by);
    }

    public SelenideWebElement(SelenideElement selenideElement) {
        this.selenideWebElement = selenideElement;
    }

    @Override
    public String getText() {
        return this.selenideWebElement.getText();
    }

    @Override
    public String getTitle() {
        return this.selenideWebElement.getAttribute("title");
    }

    @Override
    public IWebElement setInputValue(String value) {
        return new SelenideWebElement(this.selenideWebElement.setValue(value));
    }

    @Override
    public IWebElement click() {
        this.selenideWebElement.click();
        return this;
    }

    @Override
    public IWebElement clear() {
        this.selenideWebElement.clear();
        return this;
    }

    @Override
    public boolean hasText(String text) {
        return this.selenideWebElement.has(Condition.text(text));
    }

    @Override
    public IWebElement shouldHaveExactText(String exactText) {
        this.selenideWebElement.shouldHave(Condition.exactText(exactText));
        return this;
    }

    @Override
    public IWebElement shouldHaveExactText(String exactText, Duration duration) {
        this.selenideWebElement.shouldHave(Condition.exactText(exactText), duration);
        return this;
    }

    @Override
    public IWebElement shouldHaveText(String text) {
        this.selenideWebElement.shouldHave(Condition.text(text));
        return this;
    }

    @Override
    public IWebElement shouldHaveText(String exactText, Duration duration) {
        this.selenideWebElement.shouldHave(Condition.text(exactText), duration);
        return this;
    }

    @Override
    public IWebElement shouldNotHaveText(String text) {
        this.selenideWebElement.shouldNotHave(Condition.text(text));
        return this;
    }

    @Override
    public IWebElement shouldNotHaveText(String exactText, Duration duration) {
        this.selenideWebElement.shouldNotHave(Condition.text(exactText), duration);
        return this;
    }

    @Override
    public IWebElement shouldHaveTitle(String title) {
        this.selenideWebElement.shouldHave(Condition.attribute("title", title));
        return this;
    }

    @Override
    public void shouldHaveTitle(String title, Duration duration) {
        this.selenideWebElement.shouldHave(Condition.attribute("title", title), duration);
    }

    @Override
    public IWebElement shouldNotHaveTitle(String title) {
        this.selenideWebElement.shouldNotHave(Condition.attribute("title", title));
        return this;
    }

    @Override
    public IWebElement shouldHaveAttribute(String attribute, String value) {
        this.selenideWebElement.shouldHave(Condition.attribute(attribute, value));
        return this;
    }

    @Override
    public IWebElement shouldNotHaveAttribute(String attributeName) {
        this.selenideWebElement.shouldNotHave(Condition.attribute(attributeName));
        return this;
    }

    @Override
    public IWebElement shouldHaveValue(String value) {
        this.selenideWebElement.shouldHave(Condition.value(value));
        return this;
    }

    @Override
    public IWebElement shouldAppears() {
        this.selenideWebElement.should(Condition.appear);
        return this;
    }

    @Override
    public IWebElement shouldAppears(Duration duration) {
        this.selenideWebElement.should(Condition.appear, duration);
        return this;
    }

    @Override
    public IWebElement shouldDisappears() {
        this.selenideWebElement.should(Condition.disappear);
        return this;
    }

    @Override
    public IWebElement shouldDisappears(Duration duration) {
        this.selenideWebElement.should(Condition.disappear, duration);
        return this;
    }

    @Override
    public IWebElement shouldBeDisabled() {
        this.selenideWebElement.should(Condition.disabled);
        return this;
    }

    @Override
    public IWebElement findByClass(String className) {
        return new SelenideWebElement(this.selenideWebElement.find(By.className(className)));
    }

    @Override
    public IWebElement findByCss(String selector) {
        return new SelenideWebElement(this.selenideWebElement.find(By.cssSelector(selector)));
    }

    @Override
    public IWebElement findByXpath(String xpath) {
        return new SelenideWebElement(this.selenideWebElement.find(By.xpath(xpath)));
    }

    @Override
    public IWebElement findByTitle(String title) {
        return new SelenideWebElement(this.selenideWebElement.find(Selectors.byTitle(title)));
    }

    @Override
    public IWebElement findByText(String text) {
        return new SelenideWebElement(this.selenideWebElement.find(Selectors.byText(text)));
    }

    @Override
    public boolean isChecked() {
        return this.selenideWebElement.is(Condition.checked);
    }

    @Override
    public IWebElement scrollIntoViewTop() {
        this.selenideWebElement.scrollIntoView(true);
        return this;
    }

    @Override
    public IWebElement scrollIntoViewBottom() {
        this.selenideWebElement.scrollIntoView(false);
        return this;
    }

    @Override
    public IWebElements findAllByCss(String selector) {
        return new SelenideWebElements(this.selenideWebElement.findAll(selector));
    }

    @Override
    public IWebElement shouldBeImage() {
        this.selenideWebElement.shouldBe(Condition.image);
        return this;
    }

    @SneakyThrows
    @Override
    public File downloadFileWithExtension(String extension) {
        return this.selenideWebElement.download(withExtension(extension));
    }

    @Override
    public IWebElement closest(String selector) {
        return new SelenideWebElement(this.selenideWebElement.closest(selector));
    }

    @Override
    public IWebElement sendKeys(CharSequence... keysToSend) {
        this.selenideWebElement.sendKeys(keysToSend);
        return this;
    }

    @Override
    public IWebElement shouldHaveClass(String className) {
        this.selenideWebElement.shouldHave(Condition.cssClass(className));
        return this;
    }

    @Override
    public boolean hasClass(String className) {
        return this.selenideWebElement.has(Condition.cssClass(className));
    }

    @Override
    public IWebElement shouldBeEnabled() {
        this.selenideWebElement.shouldBe(Condition.enabled);
        return this;
    }

    @Override
    public boolean isVisible() {
        return this.selenideWebElement.isDisplayed();
    }

    @Override
    public boolean isExists() {
        return this.selenideWebElement.is(Condition.exist);
    }

    @Override
    public boolean hasAttribute(String attributeName) {
        return this.selenideWebElement.has(Condition.attribute(attributeName));
    }

    @Override
    public boolean hasAttribute(String attributeName, String attributeValue) {
        return this.selenideWebElement.has(Condition.attribute(attributeName, attributeValue));
    }
}
