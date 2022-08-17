import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Register {

    WebDriver driver;
    RandomGen ran=new RandomGen();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Positive Scenario
    @Test
    public void RegisterPass() throws NoSuchElementException,InterruptedException {

        // Navigate to registration form
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();

        // Generate Credentials
        driver.findElement(By.id("gender-male")).click();
//        driver.findElement(By.partialLinkText("gender-female")).click();
        String firstName=ran.generateRandom(6);
        String lastName=ran.generateRandom(8);
        String Email=ran.generateRandom(8);
        String Password=ran.generateRandom(10);

        // Fill in Credentials
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(Email+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
        driver.findElement(By.id("register-button")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.className("ico-logout")).click();

        // Check that registration was successful by locating logout button
        WebElement logout=driver.findElement(By.className("ico-logout"));
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
        String firstName=ran.generateRandom(6);
        String lastName=ran.generateRandom(8);
        String Password=ran.generateRandom(10);
        String Email="Smith1212";

        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(Email+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.className("validation-summary-errors"));
        assertTrue(logout.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
