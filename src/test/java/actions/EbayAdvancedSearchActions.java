package actions;

import elements.EbayAdvancedSearchElements;
import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class EbayAdvancedSearchActions {

    private WebDriver driver;
    private EbayAdvancedSearchElements elements;

    public EbayAdvancedSearchActions(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        this.elements = new EbayAdvancedSearchElements(driver);
    }

    public void clickOnEbayLogo() {
        elements.ebayLogo.click();
    }

    public void enterSearchString(String string) {
        elements.searchString.sendKeys(string);
    }

    public void enterExcludeString(String string) {
        elements.excludeString.sendKeys(string);
    }

    public void enterMinPrice(String string) {
        elements.minPrice.sendKeys(string);
    }

    public void enterMaxPrice(String string) {
        elements.maxPrice.sendKeys(string);
    }

    public void clickOnSearchButton() {
        elements.searchButton.click();
    }


}
