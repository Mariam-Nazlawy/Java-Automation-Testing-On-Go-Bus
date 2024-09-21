package com.gobus.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static int duration;
    public void setDriver(WebDriver driver, int duration){
        BasePage.driver = driver;
        BasePage.duration = duration;
        BasePage.wait = new WebDriverWait(driver, Duration.ofSeconds(BasePage.duration));
    }

    public static WebElement find(By locator){

        return driver.findElement(locator);
    }

    public void set(By locator,String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public static void click(By locator){

        find(locator).click();
    }

    public static WebElement findElementUntilBeVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement findElementUntilBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getText(By locator){
        return find(locator).getText();
    }

    public static void delay(int milliseconds) {
        // Demo Purpose
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException exc) {
            exc.printStackTrace();
        }
    }

}
