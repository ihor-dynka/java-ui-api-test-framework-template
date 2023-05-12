package web.wfd;

import lombok.Getter;
import web.pages.AbstractPage;
import web.webelement.IWebElement;

import java.time.Duration;

@Getter
public class Tile extends AbstractPage {

    private IWebElement tile;
    private IWebElement tileBody;

    public Tile getTile(String tileName) {
        getWebdriver().switchToDefaultContent();
        this.tile = getTileBox(tileName).shouldHaveText(tileName);
        return this;
    }

    public void switchToTileBody(String tileName) {
        getTileBox(tileName).shouldAppears(Duration.ofSeconds(60));
        getWebdriver().switchToFrameByXpath(getTileBoxXpath(tileName) + "//iframe");
        this.tileBody = getWebdriver().getElementById("app");
    }

    public void waitUntilSsoLoggingIn() {
        this.tileBody
                .findByText("Log in through single sign-on...")
                .scrollIntoViewBottom()
                .shouldAppears(Duration.ofMinutes(1))
                .shouldDisappears(Duration.ofMinutes(1));
    }

    public Tile refresh() {
        getWebdriver().switchToDefaultContent();
        this.tile.findByCss(".toolbar button").click();
        getWebdriver().getElementByCss(".dropdown-btn [aria-label=Refresh]").shouldHaveExactText("Refresh").click();
        return this;
    }

    private IWebElement getTileBox(String tileName) {
        return getWebdriver().getElementByXpath(getTileBoxXpath(tileName));
    }

    private String getTileBoxXpath(String tileName) {
        return "//*[text()='" + tileName + "']/ancestor::*[@class='tile box']";
    }
}
