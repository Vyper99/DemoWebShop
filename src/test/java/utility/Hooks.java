package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before()
    public void setUp() throws MalformedURLException {

//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            System.out.println("Before getting called");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if(isJUnitTest()) {

            SafariOptions browserOptions = new SafariOptions();
            browserOptions.setPlatformName("macOS 12");
            browserOptions.setBrowserVersion("15");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("name", "SafariTesting");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://oauth-ferrousbear-d8f6a:d7b96c93-db98-4404-bf06-8f37d0109bc0@ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }


    }

    public static boolean isJUnitTest() {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }

    @After
    public void breakDown(){
            driver.quit();
        }

}

