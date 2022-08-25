package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static utility.Hooks.driver;

public class DesktopPurchase {

    @When("User Adds Desktop Computer to Cart")
    public void user_adds_desktop_computer_to_cart() throws InterruptedException {
        // Go to Demowebshop home page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");

        // Find Expensive Computer & Add To Cart
        driver.findElement(By.cssSelector(".top-menu [href=\"/computers\"]")).click();
        driver.findElement(By.cssSelector(":nth-child(1) > div > h2")).click();
//        driver.findElement(By.cssSelector(" div:nth-child(3) > div > div.details > h2 > a")).click();   // alternative selector for expensive computer; unused
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(":nth-child(3) > div > div.details div.buttons > input")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div #add-to-cart-button-74")).click();
        Thread.sleep(2000);

        // Verify Item Is In Cart
        WebElement cart=driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));
        Actions action = new Actions(driver);
        action.moveToElement(cart).perform();
        Thread.sleep(2000);
        String expected = "Build your own expensive computer";
        String actual = driver.findElement(By.cssSelector("#flyout-cart div.name > a")).getText();
//        System.out.println("actual: " + actual);
        assertEquals(expected, actual);

        //Go To Cart
        driver.findElement(By.cssSelector("#flyout-cart input")).click();




    }
    @Then("Checks-out Successfully")
    public void checks_out_successfully() throws InterruptedException {

        // Use Checkout method to complete Checkout
        Checkout checkout = new Checkout();
        checkout.setDriver(driver);
        checkout.Checkout();
    }

}
