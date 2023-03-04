package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();
    }

    @After("@Test")
    public void testAfterHooker() {
        System.out.println("Scenario specific hooks - testAfterHooker executed");
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(1000);
    }

    @Before("@setCookies")
    public void setCookies() {
        System.out.println("Scenario specific hooks - setCookies executed");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
