package actions;

import elements.EbayHomeElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.CommonSteps;

import java.util.List;

public class EbayHomeActions {

    private WebDriver driver;
    private EbayHomeElements elements;

    public EbayHomeActions(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        this.elements = new EbayHomeElements(driver);
    }

    public void clickAdvancedLink() {
        elements.advancedLink.click();
    }

    public void searchAnItem(String searchString) {
        elements.searchBox.sendKeys(searchString);
    }

    public void clickSearchButton() {
        elements.searchButton.click();
    }

    public int getSearchItemCount() {
        String itemCountRawText = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText().trim();
        String itemCountText = itemCountRawText.replace(",", "");
        return Integer.parseInt(itemCountText);
    }

    public void selectCategoryOption(String option) {
        List<WebElement> cat = elements.catOptions;
        for (WebElement x : cat) {
            if (x.getText().trim().equalsIgnoreCase(option)) {
                x.click();
                break;
            }
        }
    }

    public void clickOnLinkByText(String text) {
        driver.findElement(By.linkText(text)).click();
    }
}
