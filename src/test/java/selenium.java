import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
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
//        driver.quit();
    }

}
