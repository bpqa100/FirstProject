package com.telran.ilcarro.qa26;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!isUserLoggedIn()){
            logIn();
        }
    }
    @Test
    public void logoutTest() throws InterruptedException {

        clickLogOutButton();
        //Assert.assertTrue(isRegistrationFormPresent());

    }

}
