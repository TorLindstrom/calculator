package com.cicd.calculator.selenium.testCases.environment;

import com.cicd.calculator.selenium.testCases.GenericTestCases;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefoxEnvironmentTest extends GenericTestCases {

    protected firefoxEnvironmentTest() {
        super(new FirefoxDriver());
    }

}
