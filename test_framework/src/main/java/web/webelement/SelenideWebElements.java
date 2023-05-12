package web.webelement;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SelenideWebElements implements IWebElements {

    private final ElementsCollection selenideWebElements;

    public SelenideWebElements(By by) {
        this.selenideWebElements = Selenide.elements(by);
    }

    public SelenideWebElements(ElementsCollection selenideWebElements) {
        this.selenideWebElements = selenideWebElements;
    }

    @Override
    public IWebElements filterByText(String text) {
        return new SelenideWebElements(selenideWebElements.filterBy(Condition.text(text)));
    }

    @Override
    public IWebElement first() {
        return new SelenideWebElement(this.selenideWebElements.shouldHave(CollectionCondition.sizeGreaterThan(0)).first());
    }

    @Override
    public IWebElement last() {
        return new SelenideWebElement(this.selenideWebElements.shouldHave(CollectionCondition.sizeGreaterThan(0)).last());
    }

    @Override
    public IWebElement findByExactText(String text) {
        return new SelenideWebElement(this.selenideWebElements.find(Condition.exactText(text)));
    }

    @Override
    public IWebElement findByText(String text) {
        return new SelenideWebElement(this.selenideWebElements.find(Condition.text(text)));
    }

    @Override
    public IWebElements filterByVisibility() {
        return new SelenideWebElements(this.selenideWebElements.filterBy(Condition.visible));
    }

    @Override
    public IWebElements shouldHaveTexts(String... texts) {
        this.selenideWebElements.shouldHave(CollectionCondition.texts(texts));
        return this;
    }

    @Override
    public IWebElements excludeEmpty() {
        return new SelenideWebElements(this.selenideWebElements.exclude(Condition.empty));
    }

    @Override
    public IWebElements filterByContainingText(String text) {
        return new SelenideWebElements(this.selenideWebElements.filterBy(Condition.text(text)));
    }

    @Override
    public List<IWebElement> toWebElementsList() {
        return this.selenideWebElements.stream()
                .map(SelenideWebElement::new)
                .collect(Collectors.toList());
    }
}
