package com.telran.ilcarro.qa26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {


    WebDriver webDr;


    @BeforeMethod
    public void setUp() {
        webDr = new ChromeDriver();
        webDr.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isRegistrationFormPresent() {
        return webDr.findElements(By.xpath("//h2[contains(.,'Registration')]")).size() > 0;
    }

    public void fillRegForm(String fName, String lName, String email, String password) {
        type(By.id("first_name"), fName);
        type(By.id("second_name"), lName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    protected void chekBoxButton() {
        click(By.cssSelector("[name=\"check_policy\"]"));
    }

    public void click(By locator) {
        webDr.findElement(locator).click();
    }

    public void type(By locator, String text) {
        webDr.findElement(locator).click();
        webDr.findElement(locator).clear();
        webDr.findElement(locator).sendKeys(text);

    }

    public void clickOpenRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void pause() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void clickYallaButton() {
        webDr.findElement(By.cssSelector("[value=\"Y'alla!\"]")).click();
    }


    public void clickLoginButton() {
        click(By.cssSelector("[href=\"/login\"]"));
    }

    @AfterMethod
    public void tearDown() {
        webDr.quit();
    }
}
