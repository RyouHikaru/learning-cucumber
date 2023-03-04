package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonSteps {
    private WebDriver driver;

    @Before(order = 0)
    public void setUp() {
        driver = new EdgeDriver();
    }

    @After(order = 1)
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(1000);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
