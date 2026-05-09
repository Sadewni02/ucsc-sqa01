package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import java.time.Duration;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;

@Feature("Amazon Selenium Tests")
public class Demo {
    protected WebDriver driver;

    @BeforeMethod 
    public void setUp() {
        // Corrected casing: WebDriverManager (starts with Uppercase W)
            options.addArguments("--headless=new");
        
        // Corrected casing: ChromeOptions
        ChromeOptions options = new ChromeOptions();
            // If running in CI (GitHub Actions) or an environment with Chromium binary,
            // set the binary path if available so ChromeDriver can find the browser.
            String chromeBinary = System.getenv("CHROME_BIN");
            if (chromeBinary == null || chromeBinary.isEmpty()) {
                // Common locations on Linux runners
                if (new java.io.File("/usr/bin/google-chrome-stable").exists()) {
                    chromeBinary = "/usr/bin/google-chrome-stable";
                } else if (new java.io.File("/usr/bin/google-chrome").exists()) {
                    chromeBinary = "/usr/bin/google-chrome";
                } else if (new java.io.File("/usr/bin/chromium-browser").exists()) {
                    chromeBinary = "/usr/bin/chromium-browser";
                } else if (new java.io.File("/usr/bin/chromium").exists()) {
                    chromeBinary = "/usr/bin/chromium";
                }
            }
            if (chromeBinary != null && !chromeBinary.isEmpty()) {
                options.setBinary(chromeBinary);
            }
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
            
            // Wait for the search results container to appear and assert it's present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
            Assert.assertTrue(driver.findElements(By.id("search")).size() > 0, "Search results container not found");
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