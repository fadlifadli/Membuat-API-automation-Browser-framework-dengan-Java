import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class selenium {

    public static WebDriver driver;

    @Test
    public void helloJayjay() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://jayjay.co/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//h3[contains(text(),'QA ENGINEER')]")).click();
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/a[1]")).click();
        driver.findElement(By.cssSelector("#send_form_info")).click();
//        assertEquals("kolom harus diisi", "text");
        driver.quit();
    }

    @Test
    public void Firefoxjayjay() throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--window-size=1920,1080");
//        driver = new ChromeDriver(options);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://jayjay.co/");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void Locator(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name"));
        driver.findElement(By.xpath("//*[@id=\"password\"]"));
        driver.findElement(By.id("login-button"));
        driver.quit();
    }

}
