package saucedemo.POM.junitTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import saucedemo.POM.Page.HomePage;
import saucedemo.POM.Page.LoginPage;

import java.time.Duration;

public class LoginTest {
    public static WebDriver driver;

    @Test
    public void loginTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://saucedemo.com/");


        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        homePage.validateBackPackDisplayed();
        driver.quit();
    }
}
