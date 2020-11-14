package com.cicd.calculator.selenium.testCases.chrome;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class ChromeTests extends ChromeTestProcedure {

    @Test
    public void testTitle(){
        chromeDriver.get("http://localhost:8080/add");
        assertEquals("Calculator - ADD", chromeDriver.getTitle());
    }

    @Test
    public void testBottomLinkXpath(){
        chromeDriver.get("http://localhost:8080/add");
        WebElement bottomLink = chromeDriver.findElement(By.ByXPath.xpath("/html/body/div[3]/p/a"));
        String bottomLinkHrefValue = bottomLink.getAttribute("href");
        chromeDriver.get(bottomLinkHrefValue);
        assertEquals(bottomLinkHrefValue, chromeDriver.getCurrentUrl());
    }

    @Test
    public void testAddFunction(){
        chromeDriver.get("http://localhost:8080/add");
        chromeDriver.findElement(By.id("firstValue")).sendKeys("5");
        chromeDriver.findElement(By.id("secondValue")).sendKeys("2");
        chromeDriver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(7, Integer.parseInt(chromeDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testSubtractionLinkCSSSelector(){
        chromeDriver.get("http://localhost:8080/add");
        chromeDriver.findElement(By.cssSelector(".menu > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")).click();
        assertEquals("http://localhost:8080/subtract", chromeDriver.getCurrentUrl());
    }

    @Test
    public void testSubFunction(){
        chromeDriver.get("http://localhost:8080/subtract");
        chromeDriver.findElement(By.id("firstValue")).sendKeys("3");
        chromeDriver.findElement(By.id("secondValue")).sendKeys("5");
        chromeDriver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(-2, Integer.parseInt(chromeDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testMultiplicationLinkXPath(){
        chromeDriver.get("http://localhost:8080/add");
        chromeDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[3]/a")).click();
        assertEquals("http://localhost:8080/multiply", chromeDriver.getCurrentUrl());
    }

    @Test
    public void testMultiplyFunction(){
        chromeDriver.get("http://localhost:8080/multiply");
        chromeDriver.findElement(By.id("firstValue")).sendKeys("4");
        chromeDriver.findElement(By.id("secondValue")).sendKeys("4");
        chromeDriver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(16, Integer.parseInt(chromeDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testDivisionLinkXPath(){
        chromeDriver.get("http://localhost:8080/add");
        chromeDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[4]/a")).click();
        assertEquals("http://localhost:8080/divide", chromeDriver.getCurrentUrl());
    }

    @Test
    public void testDivisionFunction(){
        chromeDriver.get("http://localhost:8080/divide");
        chromeDriver.findElement(By.id("firstValue")).sendKeys("10");
        chromeDriver.findElement(By.id("secondValue")).sendKeys("4");
        chromeDriver.findElement(By.cssSelector(".submit-btn")).click();
        assertEquals(2.5, Double.parseDouble(chromeDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText()));
    }

    @Test
    public void testQuoteLinkXPath(){
        chromeDriver.get("http://localhost:8080/add");
        chromeDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[5]/a")).click();
        assertEquals("http://localhost:8080/quote", chromeDriver.getCurrentUrl());
    }

    @RepeatedTest(3)
    public void testQuoteFunction(){
        chromeDriver.get("http://localhost:8080/quote");
        String quote = chromeDriver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText();
        assertAll(()->assertNotNull(quote), ()->assertFalse(quote.isEmpty()));
    }

}
