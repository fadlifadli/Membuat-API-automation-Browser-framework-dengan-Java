package saucedemo.WaitMethod;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FluentWaitTest {
    public static WebDriver driver;

    @Test
    public void loginTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        FluentWait<WebDriver> wait= new FluentWait<>(driver);

        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());

        driver.quit();
    }
}
