package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
public class DesktopPurchase {

    WebDriver driver;

    @When("User Purchases Desktop Computer")
    public void user_purchases_desktop_computer() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");
        driver.findElement(By.cssSelector(".top-menu [href=\"/computers\"]")).click();

    }
    @Then("Checkout Successfully")
    public void checkout_successfully() {


    }
}
