package saucedemo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public static WebDriver driver;
    @Test
    public  void BrowserMethodTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com/");

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Title pada halam web: " +title);
        System.out.println("URL saat ini pada halaman web: " +currentURL);
        driver.quit();

    }
}
