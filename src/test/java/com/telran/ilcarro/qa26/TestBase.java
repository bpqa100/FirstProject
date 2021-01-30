package com.telran.ilcarro.qa26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {


    WebDriver webDr;


    @BeforeClass
    public void setUp() {
        webDr = new ChromeDriver();
        webDr.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void logIn() throws InterruptedException {
        clickLoginButton();
        type(By.name("email"), "hi2732@gmail.com");
        type(By.name("password"), "Ab1234567");
        pause();
        clickYallaButton();

    }

    public boolean isRegistrationFormPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Registration')]"));
    }

    public boolean isElementPresent(By locator) {
        return webDr.findElements(locator).size() > 0;
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

    @AfterClass
    public void tearDown() {
        webDr.quit();
    }

    public void clickLogOutButton() {
        webDr.findElement(By.xpath("//a[contains(., 'logOut')]")).click();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));

    }
}
