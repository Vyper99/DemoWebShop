package stepDefinitions;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static utility.Hooks.driver;

public class CameraPurchase {

    @When("User Purchases DSLR Camera")
    public void user_purchases_dslr_camera() throws InterruptedException {
        // Go to Demowebshop home page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");

        // Find DSLR Camera & Add To Cart
        driver.findElement(By.cssSelector(".top-menu > li:nth-child(3) > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(":nth-child(1) > div > h2 > a")).click();
//        driver.findElement(By.cssSelector(" div:nth-child(3) > div > div.details > h2 > a")).click();   // alternative selector for Camera; unused
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(":nth-child(3) > div > div.details > h2 > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#add-to-cart-button-19")).click();
        Thread.sleep(2000);

        // Verify Item Is In Cart
        WebElement cart=driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));
        Actions action = new Actions(driver);
        action.moveToElement(cart).perform();
        Thread.sleep(2000);
        String expected = "Digital SLR - Special edition";
        String actual = driver.findElement(By.cssSelector("#flyout-cart div.name > a")).getText();
//        System.out.println("actual: " + actual);
        assertEquals(expected, actual);

        //Go To Cart
        driver.findElement(By.cssSelector("#flyout-cart input")).click();
    }

}
