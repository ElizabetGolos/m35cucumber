package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.Keys.ENTER;


/**
 * Варинаты запуска сценариев:
 * Команда 'mvn clean test' в консоли
 * Через UI intellij IDEA
 */
public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final  ChooseGoods  chooseGoods;
    public static final SearchResults searchResults;
    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BK125\\IdeaProjects\\m35cucumber\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        chooseGoods = new ChooseGoods(webDriver);
        searchResults = new SearchResults (webDriver);


    }
    @Given("url {string}")
    public void url(String url) {
     chooseGoods.go(url);
    }
    @Then("accept all cookies")
    public void accept_all_cookies() {
        chooseGoods.accept_all_cookies();
}
    @Then("start search {string}")
    public void searchGood (String good) {
        chooseGoods.searchGood(good);
    }
    @Then("assert that chosen good is {string}")
    public void assert_that_chosen_good_is(String expectedGood) {
    final String getCurrentGood = searchResults.getCurrentGood();
        assertEquals(expectedGood,getCurrentGood);
    }

    @Then("input the wong e-mail {string}")
    public void input_the_wong_e_mail(String email) {
        webDriver.findElement(By.cssSelector(".userToolsText")).click();
        webDriver.findElement(By.cssSelector(".Button-module__buttonText > span")).click();
       chooseGoods.incorrect_entrance(email);

    }
    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String expectedMessage) {
//        final String getErrorMessage = new getErrorMessage();
//        assertEquals(expectedMessage,getErrorMessage);

    }
    @Then("close browser")
    public void close_browser() {
        webDriver.close();
    }

}
