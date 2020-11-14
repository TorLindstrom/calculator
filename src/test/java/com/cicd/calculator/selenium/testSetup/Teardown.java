package com.cicd.calculator.selenium.testSetup;

import org.springframework.test.context.event.annotation.AfterTestClass;

public abstract class Teardown extends HelperMethods{

    //forces the test classes to deal with closing their webDriver
    @AfterTestClass
    public abstract void teardownClass();

}
