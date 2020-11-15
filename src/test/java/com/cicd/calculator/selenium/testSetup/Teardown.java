package com.cicd.calculator.selenium.testSetup;

import org.junit.jupiter.api.AfterAll;

public abstract class Teardown extends PageHandling {

    //reset after every instance of genericTestCases has run
    @AfterAll
    public static void teardown(){
        driver.quit();
        context.close();
    }

}
