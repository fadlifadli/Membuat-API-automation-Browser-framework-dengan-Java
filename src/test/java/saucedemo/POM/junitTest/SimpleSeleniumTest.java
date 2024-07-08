package saucedemo.POM.junitTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.AssertJUnit.assertEquals;

public class SimpleSeleniumTest {
    public static WebDriver driver;
    @Test
    public void loginTest(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://saucedemo.com");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertEquals("Sauce Labs Backpak", driver.findElement(By.xpath("//*[@id\"item_4_title_link\"]/div")).getText());
        driver.quit();
    }
}
