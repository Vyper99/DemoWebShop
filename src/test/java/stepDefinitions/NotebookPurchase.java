package stepDefinitions;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static utility.Hooks.driver;
public class NotebookPurchase {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("User Adds Notebook Laptop to Cart")
    public void user_adds_notebook_laptop_to_cart() throws InterruptedException {
        // Go to Demowebshop home page
        driver.get("http://demowebshop.tricentis.com/");

        // Find Notebook Computer & Add To Cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-menu [href=\"/computers\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(2) > div > h2  > a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.add-info input"))).click();

        // Verify Item Is In Cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bar-notification > p"))); // wait until "product added to cart" message
        WebElement cart=driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));
        Actions action = new Actions(driver);
        action.moveToElement(cart).perform();
        String expected = "14.1-inch Laptop";
        String actual = driver.findElement(By.cssSelector("#flyout-cart div.name > a")).getText();
        assertEquals(expected, actual);

        //Go To Cart
        driver.findElement(By.cssSelector("#flyout-cart input")).click();
    }




}
