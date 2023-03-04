package steps;

import actions.CommonActions;
import actions.EbayAdvancedSearchActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.fail;

public class EbayAdvancedSearchSteps {

    private final CommonActions commonActions;
    private final EbayAdvancedSearchActions advancedSearchActions;

    public EbayAdvancedSearchSteps(CommonActions commonActions, EbayAdvancedSearchActions advancedSearchActions) {
        this.commonActions = commonActions;;
        this.advancedSearchActions = advancedSearchActions;
    }

    @Given("I am on Ebay Advanced Search page")
    public void i_am_on_ebay_advanced_search_page() {
        commonActions.goToURL("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay Logo")
    public void i_click_on_ebay_logo() {
        advancedSearchActions.clickOnEbayLogo();
    }

    @Then("I navigate back to Ebay Homepage")
    public void i_navigate_back_to_ebay_homepage() {
        String expectedURL = "https://www.ebay.com/";
        String actualURL = commonActions.getCurrentPageURL();

        if (!expectedURL.equals(actualURL)) {
            fail("Page did not navigated to Homepage");
        }
    }

    @When("I advanced search an item")
    public void i_advanced_search_an_item(DataTable dataTable) throws InterruptedException {
        advancedSearchActions.enterSearchString(dataTable.cell(1, 0));
        advancedSearchActions.enterExcludeString(dataTable.cell(1, 1));
        advancedSearchActions.enterMinPrice(dataTable.cell(1, 2));
        advancedSearchActions.enterMaxPrice(dataTable.cell(1, 3));
        advancedSearchActions.clickOnSearchButton();
        Thread.sleep(3000);
    }
}
