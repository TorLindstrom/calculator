package com.cicd.calculator.selenium.testCases.environment;

import com.cicd.calculator.selenium.testCases.GenericTestCases;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.firefox.FirefoxDriver;

//@Disabled
public class firefoxEnvironmentTest extends GenericTestCases {

    protected firefoxEnvironmentTest() {
        super(new FirefoxDriver());
    }

    //leaves space to be able to override testcases with firefox specific logic if needed.

}
