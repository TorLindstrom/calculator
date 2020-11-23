package com.cicd.calculator.selenium.testSetup;

import com.cicd.calculator.CalculatorApplication;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class BaseClass {

    protected static WebDriver driver;
    //saved so the calculator can close on demand
    protected static ConfigurableApplicationContext context;

    //start the calculator before all tests in one instance of genericTestCases runs
    @BeforeAll
    static void setup(){
        context = SpringApplication.run(CalculatorApplication.class);
    }

}
