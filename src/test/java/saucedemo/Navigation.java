package saucedemo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Navigation {
    public static WebDriver driver;
    @Test
    public void NavigationMethod() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.navigate().to("https://saucedemo.com/");
        driver.navigate().refresh();

//        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.navigate().to("https://jayjay.co");
        driver.navigate().back();
        driver.navigate().forward();

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Title pada halaman web: " +title);
        System.out.println("URL saat ini  pada halaman web: " +currentURL);
        driver.quit();
    }
}
