package com.example.demo;
// Generated by Selenium IDE

import com.example.demo.helpers.NoteHelper;

import com.example.demo.helpers.LoginHelper;
import com.example.demo.helpers.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.utils.Destructor;

import java.util.*;

public class ApplicationManager {
    private static NoteHelper note;
    private final WebDriver driver;
    private final NavigationHelper navigation;
    private final LoginHelper auth;
    String baseURL;
    private static final ThreadLocal<ApplicationManager> app = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(ApplicationManager.class);
    private final StringBuffer verificationErrors;

    public static ApplicationManager GetInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }

    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        Map<String, Object> vars = new HashMap<String, Object>();
        note = new NoteHelper(this);
        auth = new LoginHelper(this);
        navigation = new NavigationHelper(this);
        baseURL = "http://web.bossnote.ru/signIn/";
        navigation.setBaseUrl(baseURL);
        verificationErrors = new StringBuffer();
        Thread destructorHook = Destructor.addManagerDestructor(this);
        log.info("Destructor-thread-hook is a " + destructorHook);
    }

    public void Stop() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public LoginHelper getAuth() {
        return auth;
    }

    public static NoteHelper getNote() {
        return note;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }
}
