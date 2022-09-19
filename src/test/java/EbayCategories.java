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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EbayCategories {
    public static void main(String[] args) throws InterruptedException {
        List Expected = new ArrayList();
             Expected.add(Arrays.asList("All Categories", "Antiques", "Art", "Baby", "Books", "Business & Industrial", "Cameras & Photo", "Cell Phones & Accessories", "Clothing", "Shoes & Accessories", "Coins & Paper Money", "Collectibles", "Computers/Tablets & Networking", "Crafts", "Dolls & Bears", "DVDs & Movies", "eBay Motors", "Entertainment Memorabilia", "Gift Cards & Coupons", "Health & Beauty", "Home & Garden", "Jewelry & Watches", "Music", "Musical Instruments & Gear", "Pet Supplies", "Pottery & Glass", "Real Estate", "Specialty Services", "Sporting Goods", "Sports Mem", "Cards & Fan Shop", "Stamps", "Tickets & Experiences", "Toys & Hobbies", "Travel", "Video Games & Consoles", "Everything Else"));

        System.out.println(Expected.toString());


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Select dropdown = new Select( wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gh-cat"))));

        List<WebElement> categories = dropdown.getOptions();

        List textCategories = new ArrayList();
            for (WebElement options : categories) {
                textCategories.add(options.getText());
            }



    //    Collections.sort(Expected);
    //    Collections.sort(textCategories);

        System.out.println(Expected.toString());
        System.out.println(textCategories.toString());


        //Assert.assertEquals(Expected, textCategories);

        List<String> difference = (List<String>) textCategories.stream()
                .filter(element -> !Expected.contains(element))
                .collect(Collectors.toList());

        System.out.println(difference.toString());

        driver.close();


    }

}
