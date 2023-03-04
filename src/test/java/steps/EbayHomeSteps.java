package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    @When("I searched for {string}")
    public void i_searched_for_i_phone(String str1) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        Thread.sleep(1000);
    }

    @Then("I validate at least {int} search items present")
    public void i_validate_at_least_search_items_present(int count) {
        String itemCountRawText = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText().trim();
        String itemCountText = itemCountRawText.replace(",", "");
        int itemCount = Integer.parseInt(itemCountText);
        if (itemCount < count) {
            fail("Less than " + count + " results shown");
        }
    }

    @When("I search for {string} in {string} category")
    public void i_search_for_in_category(String string, String string2) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);
        List<WebElement> cat = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        for (WebElement x : cat) {
            if (x.getText().trim().equalsIgnoreCase(string2)) {
                x.click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        Thread.sleep(1000);
    }

    @When("I click on {string}")
    public void i_click_on(String string) throws InterruptedException {
        driver.findElement(By.linkText(string)).click();
        Thread.sleep(1000);
    }

    @Then("I validate that page navigates to {string} and title contains {string}")
    public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
        String actualURL = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();
        if (!actualURL.equals(url)) {
            fail("Page did not navigated to expected URL");
        }
        if (!actualTitle.toLowerCase().contains(title.toLowerCase())) {
            fail("Title mismatch");
        }
    }

}
