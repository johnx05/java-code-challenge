package com.sampleseleniumframework.pom;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SamplePom {

    WebDriver driver;
    
    public SamplePom()
    {
        // System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String navigateToUrl(String url)
    {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid=\"event-header-name\"]")));
        return driver.getTitle();
    }

    public String getEventTitle()
    {
        WebElement eventTitle = driver.findElement(By.cssSelector("[data-testid=\"event-header-name\"]"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(eventTitle));
        return eventTitle.getText();
    }

    public String getTotalQuestionCount()
    {
        WebElement questionCount = driver.findElement(By.cssSelector("[data-testid=\"questions-list-count\"] span"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(questionCount));
        return questionCount.getText();
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}
