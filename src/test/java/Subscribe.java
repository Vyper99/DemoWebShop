import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Subscribe {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    //Positive Scenario
    @Test
    public void Subscribe() throws InterruptedException {
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.name("NewsletterEmail")).sendKeys("smith1212@gmail.com");
        driver.findElement(By.id("newsletter-subscribe-button")).click();
        String expected="Thank you for signing up! A verification email has been sent. We appreciate your interest.";
        Thread.sleep(2000);
        String actual=driver.findElement(By.id("newsletter-result-block")).getText().trim();
        System.out.println(actual);

        assertEquals(expected, actual);



    }

    //negative scenario
    @Test
    public void subscribeFail() throws InterruptedException {
        driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.name("NewsletterEmail")).sendKeys("123");
        driver.findElement(By.id("newsletter-subscribe-button")).click();
        String expected="Enter valid email";
        Thread.sleep(2000);
        String actual=driver.findElement(By.id("newsletter-result-block")).getText().trim();
        System.out.println(actual);

        assertEquals(expected, actual);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
