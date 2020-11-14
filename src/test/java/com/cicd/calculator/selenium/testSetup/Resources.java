package com.cicd.calculator.selenium.testSetup;

import com.cicd.calculator.CalculatorApplication;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.event.annotation.BeforeTestClass;

public abstract class Resources {

    public static WebDriver driver;

    //start the calculator for all tests
    @BeforeAll
    static void setup(){
        CalculatorApplication.main(new String[]{});
    }

    //forces the test classes to deal with starting their webDriver
    @BeforeTestClass
    abstract public void setupClass();

}
