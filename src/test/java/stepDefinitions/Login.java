package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Login {
    WebDriver driver;
    String username;
    String password;
    @Given("User has valid credentials")
    public void user_has_valid_credentials() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        username = "smith1212@gmail.com";
        password = "password";
    }
    @When("User logs in")
    public void user_logs_in() {
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("RememberMe")).click();
        driver.findElement(By.id("RememberMe")).submit();
    }
    @Then("User logs in successfully")
    public void user_logs_in_successfully() {
        String expected = "Log out";
        String actual = driver.findElement(By.className("ico-logout")).getText().trim();
        assertEquals(expected, actual);
    }
}






