package com.aire.logic.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.aire.logic.utils.WebDriverHelper.getWebDriverInstance;

public class CucumberHooks {

    @After("@ui")
    public void afterScenario(Scenario scenario) {
        getWebDriverInstance(false).quit();
    }

    @Before("@ui")
    public void beforeScenario(Scenario scenario) {
        getWebDriverInstance(true);
    }
}
