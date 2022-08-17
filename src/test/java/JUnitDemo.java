import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class JUnitDemo {
    WebDriver driver;
    @Before
    public void setUp(){
        //Arrange
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void openDemoWebShop(){
        //Act
        driver.get("http://demowebshop.tricentis.com");

        //Assert title using assertEquals
        String expected =  "Demo Web Shop";
        assertEquals(expected, driver.getTitle());

    }

    @Test //User
    public void logInSuccess(){
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("smith1212@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password");
//        driver.findElement(By.id("RememberMe")).click();
        driver.findElement(By.className("login-button")).click();

    }

    @After
    public void tearDown(){
        driver.quit();

    }


}
