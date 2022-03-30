package com.aire.logic.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.aire.logic.utils.WebDriverHelper.getWebDriverInstance;
import static com.aire.logic.utils.WebDriverHelper.waitForWebElementTobePresent;

public class HomePage {

    @FindBy(id = "vrm-input")
    private WebElement enterRegNumber;

    @FindBy(xpath = "//button[text()='Free Car Check']")
    private WebElement freeCarCheck;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameToStart;

    @FindBy(xpath = "//button[text()='Start!']")
    private WebElement startButton;

    @FindBy(xpath = " //h2[text()='New Game']")
    private WebElement newGame;

    private String finalScore = "//a[text()='%name%']//following::td";

    public HomePage() {
        PageFactory.initElements(getWebDriverInstance(false), this);
    }

    public String getFinalScore(WebDriver driver, String name){
        WebElement scoreElement = driver.findElement(By.xpath(finalScore.replace("%name%",name)));
        return scoreElement.getText();
    }

    private void clickOnStartButton() {
        waitForWebElementTobePresent(startButton);
        startButton.click();
    }

    private void enterName(String name) {
        waitForWebElementTobePresent(nameToStart);
        nameToStart.clear();
        nameToStart.sendKeys(name);
    }

    public void enterAndStartGame(String name) throws InterruptedException {
        enterName(name);
        clickOnStartButton();
    }

    public boolean isNewGameExists() throws InterruptedException {
       return newGame.isDisplayed();
    }

}
