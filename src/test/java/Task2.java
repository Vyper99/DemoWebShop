import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");

        driver.findElement(By.name("q")).sendKeys("book", Keys.ENTER);

        String expected="Demo Web Shop. Search";
        String actual=driver.getTitle();

        if (expected.equals(actual)){
            System.out.println("success");
        }
        else {
            System.out.println("failure");
        }
    }
}