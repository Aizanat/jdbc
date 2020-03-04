package com.aiza.db;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By createAccountLink = By.xpath("//span[contains(text(),'Моя страница')]");


    public String getHeadingText() {
        return driver.findElement(createAccountLink).getText();
    }

}
