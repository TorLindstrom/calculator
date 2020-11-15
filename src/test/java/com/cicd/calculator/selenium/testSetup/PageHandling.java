package com.cicd.calculator.selenium.testSetup;

import org.openqa.selenium.By;

import static com.cicd.calculator.selenium.testSetup.PageHandling.WebPages.QUOTE;

public abstract class PageHandling extends BaseClass {

    //By CSS Selector and Xpath
    public By subtractButtonCss = By.cssSelector(".menu > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)");
    public By multiplyButtonXpath = By.xpath("/html/body/div[1]/div[2]/ul/li[3]/a");
    public By divideButtonXpath = By.xpath("/html/body/div[1]/div[2]/ul/li[4]/a");
    public By quoteButtonXpath = By.xpath("/html/body/div[1]/div[2]/ul/li[5]/a");
    public By bottomLinkXpath = By.xpath("/html/body/div[3]/p/a");

    //the pages of the calculator with their urls
    public enum WebPages {
        ADD("http://localhost:8080/add"),
        SUBTRACT("http://localhost:8080/subtract"),
        MULTIPLY("http://localhost:8080/multiply"),
        DIVIDE("http://localhost:8080/divide"),
        QUOTE("http://localhost:8080/quote");

        public final String url;

        WebPages(String url){
            this.url = url;
        }

        public void getWebPage(){
            driver.get(this.url);
        }
    }

    protected void clickLink(By by){
        driver.findElement(by).click();
    }

    protected String clickLinkAndGetURL(By by){
        clickLink(by);
        return driver.getCurrentUrl();
    }

    protected String getPageAndURL(String url){
        driver.get(url);
        return driver.getCurrentUrl();
    }

    //and By ID
    protected double doPageSpecificMath(int firstValue, int secondValue){
        driver.findElement(By.id("firstValue")).sendKeys("" + firstValue);
        driver.findElement(By.id("secondValue")).sendKeys("" + secondValue);
        driver.findElement(By.cssSelector(".submit-btn")).click();
        return Double.parseDouble(driver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText());
    }

    protected String extractAttribute(By by, String attribute){
        return driver.findElement(by).getAttribute(attribute);
    }

    protected String getQuote(){
        QUOTE.getWebPage();
        return driver.findElement(By.xpath("/html/body/div[2]/h3/p")).getText();
    }

}
