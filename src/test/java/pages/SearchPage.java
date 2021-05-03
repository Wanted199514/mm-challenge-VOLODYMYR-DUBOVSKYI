package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'root_d')]")
    private List<WebElement> products;

    @FindBy(id = "submit-form")
    private WebElement searchButton;

    @FindBy(id = "searchbar")
    private WebElement searchField;

    @FindBy(id = "searchbar-basic-clear")
    private WebElement clearButton;

    @FindBy(xpath = "//*[@data-testid='searchProductCountLabel']")
    private WebElement searchProductCountLabel;

    public SearchPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean searchPageIsLoaded() {
        waitUntilElementIsAppear(searchProductCountLabel);
        return webDriver.getCurrentUrl().contains("https://www.manomano.co.uk/search/");
    }

    public int sumProducts() {
        return products.size();
    }

    public void clearSearchField() {
        searchField.click();
        clearButton.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public boolean searchProductCountLabel() {
        try {
            waitForLoad(webDriver);
            return searchProductCountLabel.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }
}
