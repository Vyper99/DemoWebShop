import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class RegisterMethod {
  WebDriver driver;


  public void setDriver(WebDriver Driver){
      this.driver=Driver;

  }
    public void Register() {

        RandomGen ran = new RandomGen();


            // Navigate to registration form
            driver.get("http://demowebshop.tricentis.com");
            driver.findElement(By.partialLinkText("Register")).click();

            // Generate Credentials
            driver.findElement(By.id("gender-male")).click();
//        driver.findElement(By.partialLinkText("gender-female")).click();
            String firstName = ran.generateRandom(6);
            String lastName = ran.generateRandom(8);
            String Email = ran.generateRandom(8);
            String Password = ran.generateRandom(10);

            // Fill in Credentials
            driver.findElement(By.id("FirstName")).sendKeys(firstName);
            driver.findElement(By.id("LastName")).sendKeys(lastName);
            driver.findElement(By.id("Email")).sendKeys(Email + "@gmail.com");
            driver.findElement(By.id("Password")).sendKeys(Password);
            driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);
            driver.findElement(By.id("register-button")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.className("ico-logout")).click();

            // Check that registration was successful by locating logout button
            WebElement logout = driver.findElement(By.className("ico-logout"));
            assertTrue(logout.isDisplayed());
            driver.findElement(By.className("register-continue-button")).click();

//         if (logout.isDisplayed()) {
//            System.out.println("login successful");
//        } else {
//            System.out.println("login unsuccessful");
//        }
        }
    }
