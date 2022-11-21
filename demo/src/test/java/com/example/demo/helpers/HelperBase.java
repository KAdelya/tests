package com.example.demo.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class HelperBase {
    protected WebDriver driver;
    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
