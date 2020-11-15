package com.cicd.calculator.selenium.testCases;

import com.cicd.calculator.selenium.testSetup.Teardown;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Disabled("Abstract class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class GenericTestCases extends Teardown {

    protected GenericTestCases(WebDriver webDriver) {driver = webDriver;}

    @Test
    public void testTitle(){
        driver.get("http://localhost:8080/add");
        assertEquals("Calculator - ADD", driver.getTitle());
    }

    @Test
    public void testBottomLinkXpath(){
        driver.get("http://localhost:8080/add");
        WebElement bottomLink = driver.findElement(By.ByXPath.xpath("/html/body/div[3]/p/a"));
        String bottomLinkHrefValue = bottomLink.getAttribute("href");
        driver.get(bottomLinkHrefValue);
        assertEquals(bottomLinkHrefValue, driver.getCurrentUrl());
    }

    @Test
    public void testAddFunction(){
        driver.get("http://localhost:8080/add");
        driver.findElement(By.id("firstValue")).sendKeys("5");
        driver.findElement(By.id("secondValue")).sendKeys("2");
        driver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(7, Integer.parseInt(driver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testSubtractionLinkCSSSelector(){
        driver.get("http://localhost:8080/add");
        driver.findElement(By.cssSelector(".menu > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")).click();
        assertEquals("http://localhost:8080/subtract", driver.getCurrentUrl());
    }

    @Test
    public void testSubFunction(){
        driver.get("http://localhost:8080/subtract");
        driver.findElement(By.id("firstValue")).sendKeys("3");
        driver.findElement(By.id("secondValue")).sendKeys("5");
        driver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(-2, Integer.parseInt(driver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testMultiplicationLinkXPath(){
        driver.get("http://localhost:8080/add");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[3]/a")).click();
        assertEquals("http://localhost:8080/multiply", driver.getCurrentUrl());
    }

    @Test
    public void testMultiplyFunction(){
        driver.get("http://localhost:8080/multiply");
        driver.findElement(By.id("firstValue")).sendKeys("4");
        driver.findElement(By.id("secondValue")).sendKeys("4");
        driver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(16, Integer.parseInt(driver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testDivisionLinkXPath(){
        driver.get("http://localhost:8080/add");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[4]/a")).click();
        assertEquals("http://localhost:8080/divide", driver.getCurrentUrl());
    }

    @Test
    public void testDivisionFunction(){
        driver.get("http://localhost:8080/divide");
        driver.findElement(By.id("firstValue")).sendKeys("10");
        driver.findElement(By.id("secondValue")).sendKeys("4");
        driver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(2.5, Double.parseDouble(driver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testQuoteLinkXPath(){
        driver.get("http://localhost:8080/add");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[5]/a")).click();
        assertEquals("http://localhost:8080/quote", driver.getCurrentUrl());
    }

    @RepeatedTest(3)
    public void testQuoteFunction(){
        driver.get("http://localhost:8080/quote");
        String quote = driver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText();
        assertAll(()->assertNotNull(quote), ()->assertFalse(quote.isEmpty()));
    }

}
