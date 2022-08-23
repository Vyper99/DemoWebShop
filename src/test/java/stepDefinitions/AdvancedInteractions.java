package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static utility.Hooks.driver;

public class AdvancedInteractions {


    @Given("Customer is on Demo Web Shop")
    public void customer_is_on_demo_web_shop() {
        driver.get("https://demowebshop.tricentis.com");


    }
    @When("Customer hovers over Computers section")
    public void customer_hovers_over_computers_section() throws InterruptedException {
        WebElement computers = driver.findElement(By.cssSelector(".top-menu [href=\"/computers\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(computers).perform();
        Thread.sleep(10000);

    }
    @Then("Customer should see Desktop Section")
    public void customer_should_see_desktop_section() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("health book is in shopping cart")
    public void health_book_is_in_shopping_cart() throws InterruptedException {
        //search for book on home page
        driver.get("https://demowebshop.tricentis.com");
        driver.findElement(By.name("q")).sendKeys("book", Keys.ENTER);
        Thread.sleep(2000);

        //add book to cart
        String expected = "Health Book";
        String actual = driver.findElement(By.className("product-title")).getText().trim();
        assertEquals(expected, actual);
        driver.findElement(By.className("product-box-add-to-cart-button")).click();
        Thread.sleep(2000);



    }
    @When("customer hovers over shopping cart")
    public void customer_hovers_over_shopping_cart() throws InterruptedException {
        WebElement cart=driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));
        Actions action = new Actions(driver);
        action.moveToElement(cart).perform();
        Thread.sleep(10000);
        String expected = "Health Book";
        String actual = driver.findElement(By.cssSelector("#flyout-cart > div > div.items > div > div.product > div.name > a")).getText();
        assertEquals(expected, actual);




    }
    @Then("customer should see Health Book in shopping cart")
    public void customer_should_see_health_book_in_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions

    }



}
