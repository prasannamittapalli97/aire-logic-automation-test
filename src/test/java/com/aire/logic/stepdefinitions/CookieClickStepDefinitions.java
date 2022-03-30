package com.aire.logic.stepdefinitions;

import com.aire.logic.pageobjects.GamePage;
import com.aire.logic.pageobjects.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.aire.logic.utils.WebDriverHelper.getWebDriverInstance;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


public class CookieClickStepDefinitions {

    private HomePage homePage;
    private GamePage gamePage;
    WebDriver webDriver = null;
    private String name = "";

    // Pico container is used for dependency injection here. We can also use frameworks like spring IOC, Google guice etc
    public CookieClickStepDefinitions(HomePage homePage, GamePage gamePage) {
        this.homePage = homePage;
        this.webDriver = getWebDriverInstance(false);
        this.gamePage = gamePage;
    }

    @Given("I {string} start new game")
    public void iStartNewGame(String name) throws InterruptedException {
        this.name = name;
        homePage.enterAndStartGame(name);
    }

    @Given("I navigate to cookie collect home page")
    public void iNavigateToCookieCollectHomePage() {
        webDriver.navigate().to("https://cookieclickertechtest.airelogic.com/");
    }

    @When("I navigate to cookie collect new game page")
    public void iNavigateToCookieCollectNewGamePage() {
        assertThat(webDriver.getCurrentUrl()).contains(name);
    }

    @And("verify new game started successfully with values (.*),(.*) and (.*)")
    public void verifyNewGameStartedSuccessfullyWithValuesCookies_countFactories_countAndMoney(String cookieCount, String factoryCount, String money) {
        verifyGameValues(cookieCount, factoryCount, money);
    }

    @When("I click on cookie clicker link on game page")
    public void iClickOnCookieClickerLinkOnGamePage() {
        gamePage.clickCookieClickerLink();
    }

    @Then("I should navigate to cookie collect home page")
    public void iShouldNavigateToCookieCollectHomePage() throws InterruptedException {
        assertTrue(homePage.isNewGameExists());
    }

    @And("page should have (.*) with score (.*)")
    public void pageShouldHaveNameWithScoreScore(String name, String score) {
        String finalScore = homePage.getFinalScore(this.webDriver, name);
        assertThat(finalScore).isEqualTo(score);
    }

    @When("I click on click cookie for (.*) times")
    public void iClickOnClickCookieForNoOfTimesTimes(int noOfCookies) {
        for(int i=0;i<noOfCookies;i++){
            gamePage.clickOnCookie();
        }
    }

    @Then("verify game should be with values (.*),(.*) and (.*)")
    public void verifyGameShouldBeWithValuesCookies_countFactories_countAndMoney(String cookieCount, String factoryCount, String money) {
        verifyGameValues(cookieCount, factoryCount, money);
    }

    private void verifyGameValues(String cookieCount, String factoryCount, String money){
        assertThat(gamePage.getCookiesCount()).as("Cookie Count is coming wrong").isEqualTo(cookieCount);
        assertThat(gamePage.getFactoriesCount()).as("Factories Count is coming wrong").isEqualTo(factoryCount);
        assertThat(gamePage.getMoney()).as("Money is coming wrong").isEqualTo(money);
    }

    @When("I sell (.*) cookies")
    public void iSellNoOfCookiesCookies(String cookiesCount) {
        gamePage.enterNumberOfCookiesToSell(cookiesCount);
        gamePage.clickOnSellCookies();
    }

    @And("I buy (.*) factories")
    public void iBuyNoOfFactoriesFactories(String noOfFactories) {
        gamePage.enterNumberOfFactoriesToBuy(noOfFactories);
        gamePage.clickOnBuyFactories();
    }

    @Then("verify the cookies count should not be more than (.*)")
    public void verifyTheCookiesCountShouldNotBeMoreThanCookies_count(String cookiesCount) {
        assertThat(Integer.parseInt(gamePage.getCookiesCount())).as("Cookie Count is coming wrong")
                .isLessThan(Integer.parseInt(cookiesCount));
    }

    @And("factories count should be (.*)")
    public void factoriesCountShouldBeFactories_count(String factoriesCount) {
        assertThat(gamePage.getFactoriesCount()).as("Factories Count is coming wrong")
                .isEqualTo(factoriesCount);
    }
}
