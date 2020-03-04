package com.aizanat.cucumber.stepdefs;

import com.aiza.db.DBWorker;
import com.aiza.db.LoginPage;
import com.aiza.db.RegisterPage;
import com.aiza.db.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UserStepdefs {
    DBWorker worker = new DBWorker();

    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Given("^open the page$")
    public void openThePage() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://vk.com/");
    }

    @When("^enter user with id '(.*)'$")
    public void enterData(int id) throws Throwable {
        LoginPage loginPage = new LoginPage(driver);
        User user = worker.getUser(id);
        loginPage.toComeIn(user.getLogin(), user.getPassword());
    }

    @Then("^open page '(.*)'$")
    public void openMyPage(String textMyPage) throws Throwable {
        registerPage = new RegisterPage(driver);
        String text = registerPage.getHeadingText();
        Assert.assertEquals(textMyPage, text);

    }

}
