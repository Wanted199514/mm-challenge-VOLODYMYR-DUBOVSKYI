package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(id = "searchbar")
    private WebElement searchField;

    @FindBy(id = "submit-form")
    private WebElement searchButton;

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//*[contains(@class,'Suggestions_root')]")
    private WebElement suggestionsList;

    @FindBy(xpath = "//*[contains(@class,'SuggestionItem_link')]")
    private List<WebElement> qualitySuggestionsList;

    String mainPageURL = "https://www.manomano.co.uk/";

    public MainPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public void openMainPage() {
        webDriver.get(mainPageURL);
    }

    public String mainPageIsLoaded() {
        return webDriver.getCurrentUrl();
    }

    public String mainPageURL() {
        return mainPageURL;
    }

    public void clickOnAcceptCookiesButton() {
        waitUntilElementIsAppear(acceptCookiesButton);
        acceptCookiesButton.click();
    }

    public void clickOnSearchField() {
        searchField.click();
    }

    public void inputOnSearchField(String word) {
        searchField.sendKeys(word);
    }

    public MainPage initializeMainPage() {
        return new MainPage(webDriver);
    }

    public SearchPage clickOnSearchButton() {
        searchButton.click();
        return new SearchPage(webDriver);
    }

    public SearchPage clickOnENTER() {
        searchButton.sendKeys(Keys.ENTER);
        return new SearchPage(webDriver);
    }

    public boolean checkSuggestionsList() {
        try {
            waitUntilElementIsAppear(suggestionsList);
            return suggestionsList.isDisplayed();
        }
        catch(Exception e) {
            return false;
        }
    }

    public int sumSuggestionsList() {
        return qualitySuggestionsList.size();
    }
}
