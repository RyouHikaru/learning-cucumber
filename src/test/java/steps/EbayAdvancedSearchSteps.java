package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class EbayAdvancedSearchSteps {
    WebDriver driver;

    public EbayAdvancedSearchSteps(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
    }

    @Given("I am on Ebay Advanced Search page")
    public void i_am_on_ebay_advanced_search_page() {
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay Logo")
    public void i_click_on_ebay_logo() {
         driver.findElement(By.xpath("//a[@id='gh-la']")).click();
    }

    @Then("I navigate back to Ebay Homepage")
    public void i_navigate_back_to_ebay_homepage() {
        String expectedURL = "https://www.ebay.com/";
        String actualURL = driver.getCurrentUrl();

        if (!expectedURL.equals(actualURL)) {
            fail("Page did not navigated to Homepage");
        }
    }
}
