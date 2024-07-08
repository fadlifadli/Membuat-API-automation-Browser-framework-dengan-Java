package saucedemo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;





public class Locator {
    public static WebDriver driver;
    @Test
    public void LocatorTest(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("visual_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Swag Labs");
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(url, "https://www.saucedemo.com/inventory.html");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("item_4_title_link"));
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("visual_user");
        driver.findElement(By.id("last-name")).sendKeys("Last_visual_user");
        driver.findElement(By.id("postal-code")).sendKeys("Post_visual_user");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));
        driver.quit();
    }
}
