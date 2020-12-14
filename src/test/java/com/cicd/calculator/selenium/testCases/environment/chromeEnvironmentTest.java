package com.cicd.calculator.selenium.testCases.environment;

import com.cicd.calculator.selenium.testCases.GenericTestCases;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.chrome.ChromeDriver;

//@Disabled
public class chromeEnvironmentTest extends GenericTestCases {


    static{
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
    }

    protected chromeEnvironmentTest() {
        super(new ChromeDriver());
    }

    //leaves space to be able to override testcases with chrome specific logic if needed.

}
