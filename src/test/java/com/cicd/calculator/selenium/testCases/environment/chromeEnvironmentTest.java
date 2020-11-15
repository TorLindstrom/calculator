package com.cicd.calculator.selenium.testCases.environment;

import com.cicd.calculator.selenium.testCases.GenericTestCases;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeEnvironmentTest extends GenericTestCases {

    protected chromeEnvironmentTest() {
        super(new ChromeDriver());
    }

}
