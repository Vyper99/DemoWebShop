import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;


public class Register_junit {
    WebDriver driver;
    RandomGen ran=new RandomGen();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Positive Scenario
    @Test // REGISTRATION WITH GENDER
    public void RegisterPass() throws NoSuchElementException,InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to registration form
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();

        // Generate Credentials
        String firstName=ran.generateRandom(6);
        String lastName=ran.generateRandom(8);
        String Email=ran.generateRandom(8);
        String Password=ran.generateRandom(10);

        // Fill in Credentials
        driver.findElement(By.id("gender-male")).click();
//        driver.findElement(By.partialLinkText("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(Email+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
        driver.findElement(By.id("register-button")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.className("ico-logout")).click();

        // Check that registration was successful by locating logout button
        WebElement logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));
        //WebElement logout=driver.findElement(By.className("ico-logout"));
        assertTrue(logout.isDisplayed());

//         if (logout.isDisplayed()) {
//            System.out.println("login successful");
//        } else {
//            System.out.println("login unsuccessful");
//        }
    }

    //Negative Scenario
    @Test
    public void RegisterFail() throws NoSuchElementException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Go to Registration page
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();

        // Generate Credentials
        String firstName=ran.generateRandom(6);
        String lastName=ran.generateRandom(8);
        String Password=ran.generateRandom(10);
        String Email="Smith1212";

        // Fill in Credentials
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(Email+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
        driver.findElement(By.id("register-button")).click();

        // Check that Registration Error Message Displayed
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("validation-summary-errors")));
        assertTrue(error.isDisplayed());
    }

    @Test   // NO INPUT
    public void RegisterFail2() throws NoSuchElementException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Go to Registration page
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();

        // Attempt to Register
        driver.findElement(By.id("register-button")).click();

        // Check that Registration Error Message(s) Displayed
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".field-validation-error")));
        assertTrue(error.isDisplayed());
    }

    @Test // WRONG EMAIL FORMAT
    public void RegisterFail3() throws NoSuchElementException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Go to Registration page
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();

        // Generate Credentials
        String firstName=ran.generateRandom(6);
        String lastName=ran.generateRandom(8);
        String Password=ran.generateRandom(10);

        // Fill in Credentials
        driver.findElement(By.id("gender-male")).click();
//        driver.findElement(By.partialLinkText("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys("123456");
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
        driver.findElement(By.id("register-button")).click();


        // Check that Registration Error Message(s) Displayed
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".field-validation-error")));
        assertTrue(error.isDisplayed());

    }

    @Test // LESS THAN 6 CHARACTERS PASSWORD
    public void RegisterFail4() throws NoSuchElementException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Go to Registration page
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();

        // Generate Credentials (password less than 6 characters)
        String firstName=ran.generateRandom(6);
        String lastName=ran.generateRandom(8);
        String Email=ran.generateRandom(8);
        String Password=ran.generateRandom(5);

        // Fill in Credentials
        driver.findElement(By.id("gender-male")).click();
//        driver.findElement(By.partialLinkText("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(Email+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
        driver.findElement(By.id("register-button")).click();

        // Check that Registration Error Message(s) Displayed
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".field-validation-error")));
        assertTrue(error.isDisplayed());
    }


    @Test // PASSWORDS DON'T MATCH
    public void RegisterFail5() throws NoSuchElementException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Go to Registration page
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();

        // Generate Credentials (two different password strings)
        String firstName=ran.generateRandom(6);
        String lastName=ran.generateRandom(8);
        String Email=ran.generateRandom(8);
        String Password=ran.generateRandom(6);
        String Password2=ran.generateRandom(7);

        // Fill in Credentials
        driver.findElement(By.id("gender-male")).click();
//        driver.findElement(By.partialLinkText("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(Email+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password2);
        driver.findElement(By.id("register-button")).click();

        // Check that Registration Error Message(s) Displayed
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".field-validation-error")));
        assertTrue(error.isDisplayed());
    }

    @Test // REGISTRATION WITHOUT GENDER
    public void RegisterFail6() throws NoSuchElementException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Go to Registration page
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();

        // Generate Credentials
        String firstName=ran.generateRandom(6);
        String lastName=ran.generateRandom(8);
        String Email=ran.generateRandom(8);
        String Password=ran.generateRandom(6);

        // Fill in Credentials (minus gender)
//        driver.findElement(By.id("gender-male")).click();
//        driver.findElement(By.partialLinkText("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(Email+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
        driver.findElement(By.id("register-button")).click();

        // Check that Registration Succeeded
        WebElement logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));
        assertTrue(logout.isDisplayed());
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
