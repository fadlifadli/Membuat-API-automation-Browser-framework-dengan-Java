package saucedemo.WaitMethod;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplicitWait {
    public static WebDriver driver;

    @Test
    public void loginTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#user-name")));
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());
        driver.quit();

    }
}
