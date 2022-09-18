package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static utility.Hooks.driver;

public class DigitalDownloadsPurchase {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("User Purchases music2 under digital downloads")
    public void user_purchases_music2_under_digital_downloads() throws InterruptedException {
        // Go to Demowebshop home page
        driver.get("http://demowebshop.tricentis.com/");

        // Find Music 2 & Add To Cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-menu > li:nth-child(5) > a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(3) > div > div.details input"))).click();

        // Verify Item Is In Cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bar-notification > p"))); // wait until "product added to cart" message
        WebElement cart=driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));
        Actions action = new Actions(driver);
        action.moveToElement(cart).perform();
        String expected = "Music 2";
        String actual = driver.findElement(By.cssSelector("#flyout-cart div.name > a")).getText();
        assertEquals(expected, actual);

        //Go To Cart
        driver.findElement(By.cssSelector("#flyout-cart input")).click();
    }


}



