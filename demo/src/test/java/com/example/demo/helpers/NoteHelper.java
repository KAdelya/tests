package com.example.demo.helpers;
// Generated by Selenium IDE

import com.example.demo.ApplicationManager;
import com.example.demo.models.NoteData;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class NoteHelper extends HelperBase {
    JavascriptExecutor js;

    public NoteHelper(ApplicationManager manager) {
        driver = manager.getDriver();
        js = (JavascriptExecutor) driver;
    }

    private void saveNote() {
        driver.findElement(By.cssSelector(".btnSave")).sendKeys(Keys.ENTER);
    }

    private void switchToMainFrame() {
        driver.switchTo().defaultContent();
    }

    private void writeANote(NoteData note) {
        driver.findElement(By.id("content")).sendKeys(note.getRecord());
    }

    private void switchToFrame() {
        driver.switchTo().frame(0);
    }

    private void clickOnANoteElement() {
        driver.findElement(By.cssSelector(".leftbar-newMenu > div:nth-child(1) > img")).click();
    }

    private void waitASecond() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void addNote(NoteData note) {
        waitASecond();
        clickOnANoteElement();
        switchToFrame();
        waitASecond();
        writeANote(note);
        waitASecond();
        switchToMainFrame();
        waitASecond();
        saveNote();
        waitASecond();
    }

    public String getLastNote() {
        return driver.findElement(By.xpath("//section[1]/div[3]/p")).getText();
    }

    public void clickLastNote() {
        driver.findElement(By.xpath("//section[1]/div[3]/p")).click();
    }

    public void delayTime() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

    public void changeNote(NoteData note) throws InterruptedException {
        waitASecond();
        delayTime();
        clickLastNote();
        switchToFrame();
        waitASecond();
        writeANote(note);
        waitASecond();
        switchToMainFrame();
        waitASecond();
        saveNote();
        waitASecond();
    }

    public static String getRandomString(int minWord, int maxWord, int minLength, int maxLength) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэячсмитьбюё";
        alphabet = alphabet + alphabet.toUpperCase();
        char[] chars = alphabet.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.round(Math.random() * (maxWord - minWord)) + minWord; i++) {
            for (int j = 0; j < Math.round(Math.random() * (maxLength - minLength)) + minLength; j++) {
                stringBuilder.append(chars[(int) Math.round(Math.random() * (chars.length - 1))]);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}