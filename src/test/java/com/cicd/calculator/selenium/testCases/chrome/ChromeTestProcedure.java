package com.cicd.calculator.selenium.testCases.chrome;

import com.cicd.calculator.selenium.testSetup.Teardown;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class ChromeTestProcedure extends Teardown {
    @Override
    public void setupClass() {
        chromeDriver = new ChromeDriver();
    }

    @Override
    public void teardownClass() {
        chromeDriver.quit();
    }
}
