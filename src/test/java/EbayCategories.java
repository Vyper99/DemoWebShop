import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class EbayCategories {
    public static void main(String[] args) throws InterruptedException {
        List <String> Expected = new ArrayList(Arrays.asList("All Categories", "Antiques", "Art", "Baby", "Books", "Business & Industrial", "Cameras & Photo", "Cell Phones & Accessories", "Clothing, Shoes & Accessories", "Coins & Paper Money", "Collectibles", "Computers/Tablets & Networking", "Crafts", "Dolls & Bears", "DVDs & Movies", "eBay Motors", "Entertainment Memorabilia", "Gift Cards & Coupons", "Health & Beauty", "Home & Garden", "Jewelry & Watches", "Music", "Musical Instruments & Gear", "Pet Supplies", "Pottery & Glass", "Real Estate", "Specialty Services", "Sporting Goods", "Sports Mem, Cards & Fan Shop", "Stamps", "Tickets & Experiences", "Toys & Hobbies", "Travel", "Video Games & Consoles", "Everything Else"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Select dropdown = new Select( wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gh-cat"))));

        List<WebElement> categories = dropdown.getOptions();

        List <String> Actual = new ArrayList<>();
            for (WebElement options : categories) {
                Actual.add(options.getText().trim());
            }

        //Collections.sort(Actual);
        //Collections.sort(Expected);

        List missingExpected = new ArrayList (Actual);
            for (String options : Expected) {
                missingExpected.remove(options);
            }

        System.out.println(missingExpected);

        List missingActual = new ArrayList(Expected);
            for (String options : Actual) {
                missingActual.remove(options);
            }

        System.out.println(missingActual);

        driver.close();


    }

}
