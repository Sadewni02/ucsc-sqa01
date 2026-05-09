package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;

@Feature("Amazon Selenium Tests")
public class Demo {
    protected WebDriver driver;

    @BeforeMethod 
    public void setUp() {
        // Corrected casing: WebDriverManager (starts with Uppercase W)
        WebDriverManager.chromedriver().setup();
        
        // Corrected casing: ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        
        driver = new ChromeDriver(options);
    }

    @Test
    @Story("Homepage Verification")
    @Description("Verify Amazon homepage loads successfully and contains correct title")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("QA Team")
    public void testCase1() {
        driver.navigate().to("https://www.amazon.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"), "Amazon page title not found");
    }

    @Test
    @Story("Product Search")
    @Description("Search for a product on Amazon and verify results page appears")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("QA Team")
    public void testCase2() {
        // Test: Search for a product on Amazon and verify results page appears
        driver.navigate().to("https://www.amazon.com");
        
        // Find search box and enter search term
        var searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.sendKeys(Keys.RETURN);
        
        // Verify search results are displayed
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("results"), "Search results not found");
    }

    @Test
    @Story("Search Box Functionality")
    @Description("Verify Amazon search box visibility and input field behavior")
    @Severity(SeverityLevel.NORMAL)
    @Owner("QA Team")
    public void testCase3() {
        // Test: Verify Amazon page navigation and element visibility
        driver.navigate().to("https://www.amazon.com");
        
        // Find and verify search box is visible
        var searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isDisplayed(), "Search box is not visible");
        
        // Enter text and verify it appears in the input field
        searchBox.sendKeys("headphones");
        String inputValue = searchBox.getAttribute("value");
        Assert.assertEquals(inputValue, "headphones", "Search text not entered correctly");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  
        }
    }
}