package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver webDriver;

    protected void initializationWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    protected void waitUntilElementIsAppear(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.pollingEvery(Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForLoad(WebDriver webDriver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete") &&
                                (Boolean) ((JavascriptExecutor) webDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
                    }
                };
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(pageLoadCondition);
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDown() {
        ((JavascriptExecutor)webDriver).executeScript("scroll(0,500)");
    }
}
