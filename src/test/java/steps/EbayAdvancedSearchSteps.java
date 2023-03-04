package steps;

import io.cucumber.datatable.DataTable;
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

    @When("I advanced search an item")
    public void i_advanced_search_an_item(DataTable dataTable) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1, 0));
        driver.findElement(By.xpath("//input[@id='_ex_kw']")).sendKeys(dataTable.cell(1, 1));
        driver.findElement(By.xpath("//input[@id='s0-1-17-5[2]-@range-comp[]-@range-textbox[]-textbox']")).sendKeys(dataTable.cell(1, 2));
        driver.findElement(By.xpath("//input[@id='s0-1-17-5[2]-@range-comp[]-@range-textbox[]_1-textbox']")).sendKeys(dataTable.cell(1, 3));
        driver.findElement(By.xpath("//body/div[3]/div[1]/main[1]/form[1]/div[2]/button[1]")).click();
        Thread.sleep(3000);
    }
}
