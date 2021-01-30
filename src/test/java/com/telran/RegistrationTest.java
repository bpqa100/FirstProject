package com.telran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver webDr;

    @BeforeMethod
    public void setUp() {
        webDr = new ChromeDriver();
        webDr.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
        webDr.manage().window().maximize();
    }


    @Test
    public void testRegistration() throws InterruptedException {

        clickOpenRegForm();
        String email = "ab123"+ System.currentTimeMillis() + "@mail.ru";
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

    private boolean isRegistrationFormPresent() {
        return webDr.findElements(By.xpath("//h2[contains(.,'Registration')]")).size() > 0;
    }

    private void fillRegForm(String fName, String lName, String email, String password) {
        type(By.id("first_name"), fName);
        type(By.id("second_name"), lName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }


    private void chekBoxButton() {
        click(By.cssSelector("[name=\"check_policy\"]"));
    }

    public void type(By locator, String text) {
        webDr.findElement(locator).click();
        webDr.findElement(locator).clear();
        webDr.findElement(locator).sendKeys(text);

    }

    private void clickOpenRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }

    private void pause() throws InterruptedException {
        Thread.sleep(3000);
    }

    private void clickYallaButton() {
        webDr.findElement(By.cssSelector("[value=\"Y'alla!\"]")).click();
    }

    public void click(By locator) {
        webDr.findElement(locator).click();
    }

    @AfterMethod

    public void tearDown() {
        webDr.quit();

    }
}
