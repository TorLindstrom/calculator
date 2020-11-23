package com.cicd.calculator.selenium.testCases;

import com.cicd.calculator.selenium.testSetup.Teardown;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static com.cicd.calculator.selenium.testSetup.PageHandling.WebPages.*;
import static org.junit.jupiter.api.Assertions.*;

@Disabled("Abstract class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class GenericTestCases extends Teardown {

    protected GenericTestCases(WebDriver webDriver) {driver = webDriver;}

    @Test
    public void testTitle(){
        ADD.getWebPage();
        assertEquals("Calculator - ADD", driver.getTitle());
    }

    @Test
    public void testBottomLinkXpath(){
        ADD.getWebPage();
        String bottomLinkHrefValue = extractAttribute(bottomLinkXpath, "href");
        assertEquals(bottomLinkHrefValue, getPageAndURL(bottomLinkHrefValue));
    }

    @Test
    public void testAddFunction(){
        ADD.getWebPage();
        assertEquals(7, doPageSpecificMath(5, 2));
    }

    @Test
    public void testSubtractionLinkCSSSelector(){
        ADD.getWebPage();
        assertEquals(SUBTRACT.url, clickLinkAndGetURL(subtractButtonCss));
    }

    @Test
    public void testSubFunction(){
        SUBTRACT.getWebPage();
        assertEquals(-2, doPageSpecificMath(3, 5));
    }

    @Test
    public void testMultiplicationLinkXPath(){
        SUBTRACT.getWebPage();
        assertEquals(MULTIPLY.url, clickLinkAndGetURL(multiplyButtonXpath));
    }

    @Test
    public void testMultiplyFunction(){
        MULTIPLY.getWebPage();
        assertEquals(16, doPageSpecificMath(4, 4));
    }

    @Test
    public void testDivisionLinkXPath(){
        MULTIPLY.getWebPage();
        assertEquals(DIVIDE.url, clickLinkAndGetURL(divideButtonXpath));
    }

    @Test
    public void testDivisionFunction(){
        DIVIDE.getWebPage();
        assertEquals(2.5, doPageSpecificMath(10, 4));
    }

    @Test
    public void testQuoteLinkXPath(){
        DIVIDE.getWebPage();
        assertEquals(QUOTE.url, clickLinkAndGetURL(quoteButtonXpath));
    }

    @RepeatedTest(3)
    public void testQuoteFunction(){
        String quote = getQuote();
        assertAll(()->assertNotNull(quote), ()->assertFalse(quote.isEmpty()));
    }

}
