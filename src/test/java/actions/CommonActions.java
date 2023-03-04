package actions;

import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class CommonActions {

    private WebDriver driver;

    public CommonActions(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
    }

    public void goToURL(String url) {
        driver.get(url);
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void quitWebDriver() {
        driver.quit();
    }
}
