package ru.sf;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.getKeyFromUnicode;

public record ChooseGoods (WebDriver webDriver) {

    private static final String SEARCH_FIELD_CLASS = "catalogSearch";
    private static final String ACCEPT_ALL_COOKIES = ".Button-module__blue-primary:nth-child(2) > .Button-module__buttonText";
    private static final String ERROR_MESSAGE_SPAN_CLASS = "input-error-message__message";
    private static final String LOGIN_BUTTON = ".userToolsText";
    private static final String ENTRANCE = "login-email";


    public void go(String url) {
        webDriver.get(url);
    }

    public void searchGood(String good) {

        WebElement searchField = webDriver.findElement(By.id(SEARCH_FIELD_CLASS));
        searchField.sendKeys(good, Keys.ENTER);
    }
    public void accept_all_cookies() {
        webDriver.findElement(By.cssSelector(ACCEPT_ALL_COOKIES)).click();
    }
    public String getErrorMessage(){
       return webDriver.findElement(By.className(ERROR_MESSAGE_SPAN_CLASS)).getText();


    }

    public void incorrect_entrance (String email){

        WebElement inputEmail =  webDriver.findElement(By.id(ENTRANCE));
        inputEmail.sendKeys(email,ENTER);

    }
}