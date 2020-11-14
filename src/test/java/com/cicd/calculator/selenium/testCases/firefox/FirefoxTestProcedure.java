package com.cicd.calculator.selenium.testCases.firefox;

import com.cicd.calculator.selenium.testSetup.Teardown;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class FirefoxTestProcedure extends Teardown {
    @Override
    public void setupClass() {
        firefoxDriver = new FirefoxDriver();
    }

    @Override
    public void teardownClass(){
        firefoxDriver.quit();
    }
}
