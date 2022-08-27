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

public class Newsletter {

NewsletterHelper Helper=new NewsletterHelper();


// Successful sign-up

    @When("User Signs Up For Newsletter With Valid Email")
    public void user_signs_up_for_newsletter_with_valid_email() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(Helper.Homepage());
        driver.findElement(Helper.signupField).sendKeys(Helper.validEmail);
        driver.findElement(Helper.subscribeButton).click();
        Thread.sleep(2000);



    }
    @Then("User Should See Success Message")
    public void user_should_see_success_message() {
        String expected = Helper.successMessage;
        String actual = driver.findElement(Helper.resultBlock).getText();
        assertEquals (expected, actual);

    }



// Unsuccessful sign-up

    @When("User Signs Up For Newsletter with Invalid Email")
    public void user_signs_up_for_newsletter_with_invalid_email() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(Helper.Homepage());
        driver.findElement(Helper.signupField).sendKeys(Helper.invalidEmail);
        driver.findElement(Helper.subscribeButton).click();
        Thread.sleep(2000);

    }
    @Then("User Should See Failure Message")
    public void user_should_see_failure_message() {
        String expected = Helper.failMessage;
        String actual = driver.findElement(Helper.resultBlock).getText();
        assertEquals (expected, actual);

    }

}
