package com.aire.logic.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.aire.logic.utils.WebDriverHelper.getWebDriverInstance;
import static com.aire.logic.utils.WebDriverHelper.waitForWebElementTobePresent;

public class GamePage {

    @FindBy(xpath = "//span[@id='cookies']")
    private WebElement cookiesCount;

    @FindBy(xpath = "//span[@id='factories']")
    private WebElement factoriesCount;

    @FindBy(xpath = "//span[@id='money']")
    private WebElement money;

    @FindBy(xpath = "//a[text()='Cookie Clicker!']")
    private WebElement cookieClickerLink;

    @FindBy(xpath = "//button[@id='click']")
    private WebElement clickCookie;

    @FindBy(xpath = "//input[@id='cookies-to-sell']")
    private WebElement sellCookies;

    @FindBy(id = "sell-cookies")
    private WebElement sellCookiesButton;

    @FindBy(id = "factories-to-buy")
    private WebElement buyFactories;

    @FindBy(id = "buy-factories")
    private WebElement buyFactoriesButton;

    public GamePage() {
        PageFactory.initElements(getWebDriverInstance(false), this);
    }

    public String getCookiesCount() {
        waitForWebElementTobePresent(cookiesCount);
        return cookiesCount.getText();
    }

    public String getFactoriesCount() {
        waitForWebElementTobePresent(factoriesCount);
        return factoriesCount.getText();
    }

    public String getMoney() {
        waitForWebElementTobePresent(money);
        return money.getText();
    }

    public void clickCookieClickerLink() {
        waitForWebElementTobePresent(cookieClickerLink);
        cookieClickerLink.click();
    }

    public void clickOnCookie() {
        waitForWebElementTobePresent(clickCookie);
        clickCookie.click();
    }

    public void enterNumberOfCookiesToSell(String noOfCookies) {
        waitForWebElementTobePresent(sellCookies);
        sellCookies.sendKeys(noOfCookies);
    }

    public void clickOnSellCookies() {
        waitForWebElementTobePresent(sellCookiesButton);
        sellCookiesButton.click();
    }

    public void enterNumberOfFactoriesToBuy(String noOfFactories) {
        waitForWebElementTobePresent(buyFactories);
        buyFactories.sendKeys(noOfFactories);
    }

    public void clickOnBuyFactories() {
        waitForWebElementTobePresent(buyFactoriesButton);
        buyFactoriesButton.click();
    }

}
