package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record SearchResults(WebDriver webDriver) {
private final static String ACTIVE_GOOD_CLASS = "result__name";
     public String getCurrentGood (){
        final var actualGood = webDriver.findElement(By.className(ACTIVE_GOOD_CLASS)).getText();
         return actualGood;
     }
}
