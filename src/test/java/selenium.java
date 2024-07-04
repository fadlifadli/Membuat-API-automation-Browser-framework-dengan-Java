import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class selenium {

    @Test
    public void helloJayjay() {
//        inisialisasi browser driver
        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverManager.chromedriver().create();

//        navigasi url
        driver.get("https://jayjay.co/");
//        get element attribute
        String text = driver.findElement(By.className("first-course")).getText();
//        assertion/pernyataan
        assertEquals("Gebrakan Kursus Online yang Siap Meroketkan Kariermu", text);
    }
}
