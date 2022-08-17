import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QuitClose {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriver Chrome=new ChromeDriver();
        WebDriver Edge=new EdgeDriver();
        WebDriver Firefox=new FirefoxDriver();
        Chrome.get("http://demowebshop.tricentis.com");
        Edge.get("http://demowebshop.tricentis.com");
        Firefox.get("http://demowebshop.tricentis.com");
    }
}
