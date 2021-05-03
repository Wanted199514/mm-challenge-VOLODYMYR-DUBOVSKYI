package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;

public class MainTest extends BaseTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(mainPage.mainPageIsLoaded(), mainPage.mainPageURL(),"Main Page is not loaded.");
        mainPage.clickOnAcceptCookiesButton();
        mainPage.clickOnSearchField();
        mainPage.inputOnSearchField("pencil");
        MainPage mainPage2 = mainPage.initializeMainPage();
        Assert.assertTrue(mainPage2.checkSuggestionsList(),"Suggestions list is not loaded.");
        SearchPage searchPage = mainPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.searchPageIsLoaded(),"Search page is not loaded.");
        Assert.assertEquals(searchPage.sumProducts(),60,"Products quality is not correct.");
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(mainPage.mainPageIsLoaded(), mainPage.mainPageURL(),"Main Page is not loaded.");
        mainPage.clickOnAcceptCookiesButton();
        mainPage.clickOnSearchField();
        mainPage.inputOnSearchField("blue pencil pleat curtains");
        MainPage mainPage2 = mainPage.initializeMainPage();
        Assert.assertTrue(mainPage2.checkSuggestionsList(),"Suggestions list is not loaded.");
        Assert.assertEquals(mainPage2.sumSuggestionsList(),1,"Suggestions list quality is not correct.");
        SearchPage searchPage = mainPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.searchPageIsLoaded(),"Search page is not loaded.");
        Assert.assertEquals(searchPage.sumProducts(),17,"Products quality is not correct.");
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(mainPage.mainPageIsLoaded(), mainPage.mainPageURL(),"Main Page is not loaded.");
        mainPage.clickOnAcceptCookiesButton();
        mainPage.clickOnSearchField();
        mainPage.inputOnSearchField("pencil");
        MainPage mainPage2 = mainPage.initializeMainPage();
        Assert.assertTrue(mainPage2.checkSuggestionsList(),"Suggestions list is not loaded.");
        SearchPage searchPage = mainPage.clickOnENTER();
        Assert.assertTrue(searchPage.searchPageIsLoaded(),"Search page is not loaded.");
        Assert.assertEquals(searchPage.sumProducts(),60,"Products quality is not correct.");
    }

    @Test
    public void testCase4() {
        Assert.assertEquals(mainPage.mainPageIsLoaded(), mainPage.mainPageURL(),"Main Page is not loaded.");
        mainPage.clickOnAcceptCookiesButton();
        mainPage.clickOnSearchField();
        mainPage.inputOnSearchField("pencil blue color");
        MainPage mainPage2 = mainPage.initializeMainPage();
        Assert.assertEquals(mainPage2.sumSuggestionsList(),0,"Suggestions list quality is not empty.");
        SearchPage searchPage = mainPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.searchPageIsLoaded(),"Search page is not loaded.");
        Assert.assertEquals(searchPage.sumProducts(),20,"Products quality is not correct.");
    }

    @Test
    public void testCase6() {
        Assert.assertEquals(mainPage.mainPageIsLoaded(), mainPage.mainPageURL(),"Main Page is not loaded.");
        mainPage.clickOnAcceptCookiesButton();
        mainPage.clickOnSearchField();
        mainPage.inputOnSearchField("pencil");
        MainPage mainPage2 = mainPage.initializeMainPage();
        Assert.assertTrue(mainPage2.checkSuggestionsList(),"Suggestions list is not loaded.");
        SearchPage searchPage = mainPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.searchPageIsLoaded(),"Search page is not loaded.");
        Assert.assertEquals(searchPage.sumProducts(),60,"Products quality is not correct.");
        searchPage.clearSearchField();
        searchPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.searchProductCountLabel(),"Search page is not correct.");
    }
}
