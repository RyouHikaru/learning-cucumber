package steps;

import actions.CommonActions;
import actions.EbayHomeActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.fail;

public class EbayHomeSteps {

    private final CommonActions commonActions;
    private final EbayHomeActions homeActions;

    public EbayHomeSteps(CommonSteps commonSteps, CommonActions commonActions, EbayHomeActions homeActions) {
        this.commonActions = commonActions;
        this.homeActions = homeActions;
    }

    @Given("I am on Ebay Homepage")
    public void i_am_on_ebay_homepage() {
        commonActions.goToURL("https://www.ebay.com");
    }

    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
        homeActions.clickAdvancedLink();
    }

    @Then("I navigate to Advanced Search page")
    public void i_navigate_to_advanced_search_page() {
        String expectedURL = "https://www.ebay.com/sch/ebayadvsearch";
        String actualURL = commonActions.getCurrentPageURL();
        if (!expectedURL.equals(actualURL)) {
            fail("Page did not navigated to expected page");
        }
    }

    @When("I searched for {string}")
    public void i_searched_for_i_phone(String string) throws InterruptedException {
        homeActions.searchAnItem(string);
        homeActions.clickSearchButton();
        Thread.sleep(1000);
    }

    @Then("I validate at least {int} search items present")
    public void i_validate_at_least_search_items_present(int count) {
        int itemCount = homeActions.getSearchItemCount();
        if (itemCount < count) {
            fail("Less than " + count + " results shown");
        }
    }

    @When("I search for {string} in {string} category")
    public void i_search_for_in_category(String string, String string2) throws InterruptedException {
        homeActions.searchAnItem(string);
        homeActions.selectCategoryOption(string2);
        homeActions.clickSearchButton();
        Thread.sleep(1000);
    }

    @When("I click on {string}")
    public void i_click_on(String string) throws InterruptedException {
        homeActions.clickOnLinkByText(string);
        Thread.sleep(1000);
    }

    @Then("I validate that page navigates to {string} and title contains {string}")
    public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
        String actualURL = commonActions.getCurrentPageURL();
        String actualTitle = commonActions.getCurrentPageTitle();
        if (!actualURL.equals(url)) {
            fail("Page did not navigated to expected URL: " + url);
        }
        if (!actualTitle.toLowerCase().contains(title.toLowerCase())) {
            fail("Title mismatch");
        }
    }

}
