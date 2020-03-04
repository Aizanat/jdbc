package com.aiza.db;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By mobileNumberField = By.id("index_email");
    private By passwordField = By.id("index_pass");
    private By loginButton = By.id("index_login_button");

    public void typeUserMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void typeUserPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public RegisterPage typeLoginButton() {
        driver.findElement(loginButton).click();
        return new RegisterPage(driver);
    }

    public RegisterPage toComeIn(String mobileNumber, String password) {
        this.typeUserMobileNumber(mobileNumber);
        this.typeUserPassword(password);
        this.typeLoginButton();
        return new RegisterPage(driver);
    }

}
