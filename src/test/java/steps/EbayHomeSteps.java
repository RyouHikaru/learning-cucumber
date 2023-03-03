package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class EbayHomeSteps {
    WebDriver driver;

    public EbayHomeSteps(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
    }

    @Given("I am on Ebay Homepage")
    public void i_am_on_ebay_homepage() {
        driver.get("https://www.ebay.com");
    }

    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
        driver.findElement(By.linkText("Advanced")).click();
    }

    @Then("I navigate to Advanced Search page")
    public void i_navigate_to_advanced_search_page() {
        String expectedURL = "https://www.ebay.com/sch/ebayadvsearch";
        String actualURL = driver.getCurrentUrl();

        if (!expectedURL.equals(actualURL)) {
            fail("Page did not navigated to expected page");
        }
    }

    @When("I searched for iPhone 14")
    public void i_searched_for_i_phone() {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("iphone 14");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
    }

    @Then("I validate at least 2400 search items present")
    public void i_validate_at_least_search_items_present() {
        String itemCountRawText = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText().trim();
        String itemCountText = itemCountRawText.replace(",", "");
        int itemCount = Integer.parseInt(itemCountText);
        if (itemCount < 2400) {
            fail("Less than 2400 results shown");
        }
    }
}
