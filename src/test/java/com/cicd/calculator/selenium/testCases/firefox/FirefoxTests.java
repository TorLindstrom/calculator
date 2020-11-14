package com.cicd.calculator.selenium.testCases.firefox;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FirefoxTests extends FirefoxTestProcedure {

    @Test
    public void testTitle(){
        firefoxDriver.get("http://localhost:8080/add");
        assertEquals("Calculator - ADD", firefoxDriver.getTitle());
    }

    @Test
    public void testBottomLinkXpath(){
        firefoxDriver.get("http://localhost:8080/add");
        WebElement bottomLink = firefoxDriver.findElement(By.ByXPath.xpath("/html/body/div[3]/p/a"));
        String bottomLinkHrefValue = bottomLink.getAttribute("href");
        firefoxDriver.get(bottomLinkHrefValue);
        assertEquals(bottomLinkHrefValue, firefoxDriver.getCurrentUrl());
    }

    @Test
    public void testAddFunction(){
        firefoxDriver.get("http://localhost:8080/add");
        firefoxDriver.findElement(By.id("firstValue")).sendKeys("5");
        firefoxDriver.findElement(By.id("secondValue")).sendKeys("2");
        firefoxDriver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(7, Integer.parseInt(firefoxDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testSubtractionLinkCSSSelector(){
        firefoxDriver.get("http://localhost:8080/add");
        firefoxDriver.findElement(By.cssSelector(".menu > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")).click();
        assertEquals("http://localhost:8080/subtract", firefoxDriver.getCurrentUrl());
    }

    @Test
    public void testSubFunction(){
        firefoxDriver.get("http://localhost:8080/subtract");
        firefoxDriver.findElement(By.id("firstValue")).sendKeys("3");
        firefoxDriver.findElement(By.id("secondValue")).sendKeys("5");
        firefoxDriver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(-2, Integer.parseInt(firefoxDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testMultiplicationLinkXPath(){
        firefoxDriver.get("http://localhost:8080/add");
        firefoxDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[3]/a")).click();
        assertEquals("http://localhost:8080/multiply", firefoxDriver.getCurrentUrl());
    }

    @Test
    public void testMultiplyFunction(){
        firefoxDriver.get("http://localhost:8080/multiply");
        firefoxDriver.findElement(By.id("firstValue")).sendKeys("4");
        firefoxDriver.findElement(By.id("secondValue")).sendKeys("4");
        firefoxDriver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(16, Integer.parseInt(firefoxDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testDivisionLinkXPath(){
        firefoxDriver.get("http://localhost:8080/add");
        firefoxDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[4]/a")).click();
        assertEquals("http://localhost:8080/divide", firefoxDriver.getCurrentUrl());
    }

    @Test
    public void testDivisionFunction(){
        firefoxDriver.get("http://localhost:8080/divide");
        firefoxDriver.findElement(By.id("firstValue")).sendKeys("10");
        firefoxDriver.findElement(By.id("secondValue")).sendKeys("4");
        firefoxDriver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(2.5, Double.parseDouble(firefoxDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testQuoteLinkXPath(){
        firefoxDriver.get("http://localhost:8080/add");
        firefoxDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[5]/a")).click();
        assertEquals("http://localhost:8080/quote", firefoxDriver.getCurrentUrl());
    }

    @RepeatedTest(3)
    public void testQuoteFunction(){
        firefoxDriver.get("http://localhost:8080/quote");
        String quote = firefoxDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText();
        assertAll(()->assertNotNull(quote), ()->assertFalse(quote.isEmpty()));
    }

}
