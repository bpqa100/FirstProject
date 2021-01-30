package com.telran.ilcarro.qa26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {

        clickLoginButton();
        type(By.name("email"), "hi2732@gmail.com");
        type(By.name("password"), "Ab1234567");

        clickYallaButton();
        Assert.assertTrue(webDr.findElements(By.cssSelector("[href=\"/login\"]")).size() > 0);
    }

}



