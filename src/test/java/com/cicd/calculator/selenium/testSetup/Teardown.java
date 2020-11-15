package com.cicd.calculator.selenium.testSetup;

import org.junit.jupiter.api.AfterAll;

public abstract class Teardown extends HelperMethods{

    @AfterAll
    public static void teardown(){
        driver.quit();
        context.close();
    };

}
