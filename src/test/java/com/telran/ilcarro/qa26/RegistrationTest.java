package com.telran.ilcarro.qa26;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @Test
    public void testRegistration() throws InterruptedException {

        clickOpenRegForm();
        String email = "ab123" + System.currentTimeMillis() + "@mail.ru";
        System.out.println("email is :" + email);
        fillRegForm("Ab", "Br", email, "Ab1234567");
        chekBoxButton();
        pause();
        clickYallaButton();
        pause();
        Assert.assertFalse(isRegistrationFormPresent());

    }


    @Test
    public void testRegistrationNegative() throws InterruptedException {

        clickOpenRegForm();
        String email = "ab" + System.currentTimeMillis() + "";
        System.out.println("email is :" + email);
        fillRegForm("Ab", "Br", email, "Ab1234567");
        chekBoxButton();
        pause();
        clickYallaButton();
        Assert.assertTrue(isRegistrationFormPresent());
    }


}
