import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DogImages {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");

        driver.findElement(By.className("ico-register")).click();

        String expected="Demo Web Shop. Register";
        String actual=driver.getTitle();

        if (expected.equals(actual)){
            System.out.println("success");
        }
        else {
            System.out.println("failure");
        }
    }
}
