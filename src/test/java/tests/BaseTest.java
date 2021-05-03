package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

public class BaseTest {

    private WebDriver webDriver;
    private ChromeOptions options = new ChromeOptions();
    MainPage mainPage;

    @BeforeMethod
    protected void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\System32\\chromedriver.exe");
        webDriver = new ChromeDriver(options.addArguments("--disable-notifications"));
        webDriver.manage().window().maximize();
        mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
    }

    @AfterMethod
    protected void afterMethod() {
        webDriver.quit();
    }
}
