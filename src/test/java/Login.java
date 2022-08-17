import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Login {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Positive Scenario
    @Test
    public void loginPass() {
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("smith1212@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password");
//        driver.findElement(By.id("RememberMe")).click();
        driver.findElement(By.className("login-button")).click();
        boolean t = driver.findElement(By.className("ico-logout")).isDisplayed();
        if (t) {
            System.out.println("login successful");
        } else {
            System.out.println("login unsuccessful");
        }
    }

    //Negative Scenario
    @Test
    public void loginFail() {
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.className("login-button")).click();
        String expected = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
        String actual = driver.findElement(By.className("validation-summary-errors")).getText().trim();
//            System.out.println(actual);
        assertEquals(expected, actual);
        driver.findElement(By.id("Email")).sendKeys("smith1212@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password");
        driver.findElement(By.className("login-button")).click();
        boolean t = driver.findElement(By.className("ico-logout")).isDisplayed();
        if (t) {
            System.out.println("login successful");
        } else {
            System.out.println("login unsuccessful");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



