package saucedemo.POM.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;

public class HomePage {

    WebDriver driver;

    By backPackItem = By.xpath("//*[@id=\"item_4_title_link\"]/div");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateBackPackDisplayed() {
        assertTrue(driver.findElement(backPackItem).isDisplayed());
    }
}
