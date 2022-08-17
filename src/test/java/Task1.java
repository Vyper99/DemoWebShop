import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Dogs", Keys.ENTER);

        String expected="Dogs - Google Search";
        String actual=driver.getTitle();

        if (expected.equals(actual)){
            System.out.println("success");
        }
        else {
            System.out.println("failure");
        }
    }
}