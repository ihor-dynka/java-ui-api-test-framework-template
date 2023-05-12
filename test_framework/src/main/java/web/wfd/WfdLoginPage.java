package web.wfd;

import web.models.User;
import web.pages.AbstractPage;

import java.time.Duration;

public class WfdLoginPage extends AbstractPage {

    public void loginToWfdAs(String url, String username, String password) {
        getWebdriver().open(url);
        logIn(username, password);
    }

    public void ssoLoginToWfdAs(String ssoTenantUrl, User user) {
        getWebdriver().open(ssoTenantUrl);
        getWebdriver().getElementByText("SSO Login").click();
        logIn(user.getUsername(), user.getPassword());
        getWebdriver().getElementById("popupClose").click();
    }

    private void logIn(String username, String password) {
        getWebdriver().getElementById("idToken1").shouldAppears(Duration.ofMinutes(1)).setInputValue(username);
        getWebdriver().getElementById("idToken2").setInputValue(password);
        getWebdriver().getElementById("loginButton_0").click();
    }
}
