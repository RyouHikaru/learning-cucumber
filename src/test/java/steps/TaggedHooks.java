package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TaggedHooks {
    WebDriver driver;

    public TaggedHooks(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
    }

    @Before(value = "@setCookies", order = 1)
    public void setCookies() {
        System.out.println("Scenario specific hooks - setCookies executed");
    }

    @After(value = "@Test", order = 0)
    public void testAfterHook() {
        System.out.println("Scenario specific hooks - testAfterHook executed");
    }

}
