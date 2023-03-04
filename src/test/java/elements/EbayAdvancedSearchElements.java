package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearchElements {

    WebDriver driver;

    @FindBy(xpath = "//a[@id='gh-la']")
    public WebElement ebayLogo;

    @FindBy(xpath = "//input[@id='_nkw']")
    public WebElement searchString;

    @FindBy(xpath = "//input[@id='_ex_kw']")
    public WebElement excludeString;

    @FindBy(xpath = "//input[@id='s0-1-17-5[2]-@range-comp[]-@range-textbox[]-textbox']")
    public WebElement minPrice;

    @FindBy(xpath = "//input[@id='s0-1-17-5[2]-@range-comp[]-@range-textbox[]_1-textbox']")
    public WebElement maxPrice;

    @FindBy(xpath = "//body/div[3]/div[1]/main[1]/form[1]/div[2]/button[1]")
    public WebElement searchButton;

    public EbayAdvancedSearchElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
