package web.webelement;

import java.util.List;

public interface IWebElements {

    IWebElements filterByText(String text);

    IWebElement first();

    IWebElement last();

    IWebElement findByExactText(String text);

    IWebElement findByText(String text);

    IWebElements filterByVisibility();

    IWebElements shouldHaveTexts(String... texts);

    IWebElements excludeEmpty();

    IWebElements filterByContainingText(String text);

    List<IWebElement> toWebElementsList();
}
