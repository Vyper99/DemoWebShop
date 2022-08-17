import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookCheckout {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void Checkout() throws InterruptedException {
        //search for book on home page
        driver.get("http://demowebshop.tricentis.com/");
        driver.findElement(By.name("q")).sendKeys("book", Keys.ENTER);
        Thread.sleep(2000);

        //add book to cart
        String expected = "Health Book";
        String actual = driver.findElement(By.className("product-title")).getText().trim();
        assertEquals(expected, actual);
        driver.findElement(By.className("product-box-add-to-cart-button")).click();
        Thread.sleep(2000);

        //Verify product was added to cart & go to checkout page
        WebElement added = driver.findElement(By.className("content"));
        assertTrue(added.isDisplayed());
        driver.findElement(By.className("cart-label")).click();

        //Fill in checkout form
        driver.findElement(By.id("CountryId")).click();
        WebElement country = driver.findElement(By.id("CountryId"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("1");
        Thread.sleep(2000);
        driver.findElement(By.id("StateProvinceId")).click();
        WebElement state = driver.findElement(By.id("StateProvinceId"));
        Select selectState = new Select(state);
        selectState.selectByVisibleText("Virginia");
        driver.findElement(By.id("ZipPostalCode")).sendKeys("23173");
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

        //Login
        driver.findElement(By.id("Email")).sendKeys("smith1212@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password");
        driver.findElement(By.className("login-button")).click();
        Thread.sleep(2000);
        //Verify Checkout
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);
        expected = "Checkout";
        actual = driver.findElement(By.className("page-title")).getText();
        assertEquals(expected, actual);

        driver.findElement(By.cssSelector("#opc-billing .button-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#opc-shipping .button-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#opc-shipping_method .button-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#opc-payment_method .button-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#opc-payment_info .button-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#opc-confirm_order .button-1")).click();
        Thread.sleep(2000);
        expected = "Your order has been successfully processed!";
        actual = driver.findElement(By.className("title")).getText().trim();
        assertEquals(expected, actual);
        driver.findElement(By.className("order-completed-continue-button")).click();
        actual  = driver.getTitle();
        expected = "Demo Web Shop";
        assertEquals(expected, actual);


    }


    @After
   public void tearDown() {
        driver.quit();
    }
}
