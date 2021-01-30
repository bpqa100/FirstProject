package com.telran.ilcarro.qa26;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        /*if user logged in --> logOut*/
        if (isUserLoggedIn()) {
            clickLogOutButton();

        }
    }

    @Test
    public void testLogin() throws InterruptedException {

        clickLoginButton();
        type(By.name("email"), "hi2732@gmail.com");
        type(By.name("password"), "Ab1234567");
        pause();
        clickYallaButton();

        Assert.assertTrue(isUserLoggedIn());
    }

}



