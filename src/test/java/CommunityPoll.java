import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.sun.org.apache.xpath.internal.compiler.Token.contains;
import static org.junit.Assert.assertEquals;

public class CommunityPoll {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void TestFail(){
        driver.get("http://demowebshop.tricentis.com/");
        //driver.findElement(By.cssSelector("#button button-1")).click();
         driver.findElement(By.id("vote-poll-1")).click();
        Alert alert = driver.switchTo().alert();
        String actual=alert.getText();
        alert.accept();
        String expected="Please select an answer";
        assertEquals(expected, actual);

    }

    @Test
    public void TestPass() throws InterruptedException {
        driver.get("http://demowebshop.tricentis.com/");
        RegisterMethod register=new RegisterMethod();
        register.setDriver(driver);
        register.Register();
        driver.findElement(By.id("pollanswers-1")).click();
        //driver.findElement(By.cssSelector("#button button-1")).click();
        driver.findElement(By.id("vote-poll-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("poll-total-votes")).isDisplayed();

    }

        @After
        public void tearDown(){
            driver.quit();
        }
}
