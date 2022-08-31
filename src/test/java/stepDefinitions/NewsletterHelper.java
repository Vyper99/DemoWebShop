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

public class NewsletterHelper {


public String Homepage() {
    return "https://demowebshop.tricentis.com/";
}

// LogInPage login = PageFactory.initElements(driver, LogInPage.class);

// @Findby (css = "#Email")
// public WebElement emailInput;

// driver.findElement(By.cssSelector("#Email")).sendKeys(username);
// login.emailInput.sendKeys(login.invalidEmail);

public By signupField = By.cssSelector("#newsletter-email");

public String validEmail = "Smith1212@gmail.com";

public String invalidEmail = "12345678abcdefg";

public By subscribeButton = By.cssSelector("#newsletter-subscribe-button");

public By resultBlock = By.cssSelector("#newsletter-result-block");

public String successMessage = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";

public String failMessage = "Enter valid email";






}
