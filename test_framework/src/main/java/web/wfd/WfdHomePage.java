package web.wfd;

import lombok.Getter;
import web.pages.AbstractPage;

import java.time.Duration;

@Getter
public class WfdHomePage extends AbstractPage {

    public void shouldBeLoggedInToWfdAs() {
        getWebdriver().getElementByCss("[automation-id=employeePhotoHomeHeaderImage]").shouldAppears(Duration.ofMinutes(1));
    }
}
