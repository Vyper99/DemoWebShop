package stepDefinitions;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static utility.Hooks.driver;

                                // This is a companion page for all the Purchase Tests

public class PurchasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Initialize variables
    public String Expected;
    private String username = "smith1212@gmail.com";
    private String password = "password";



                                                // UTILITY

                                                // Go to DemoWebShop Homepage
        public void homePage() {
            driver.get("http://demowebshop.tricentis.com/");
        }

                                                // Go to Cart
        public void gotoCart(){
            driver.findElement(By.cssSelector("#flyout-cart input")).click();
        }

                                                // Set expected string when checking contents of cart
        public void setExpected(String expected) {
            this.Expected=expected;
        }

                                                // Verify item is in cart
        public void verifyCart(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bar-notification > p"))); // wait until "product added to cart" message
            WebElement cart=driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));
            Actions action = new Actions(driver);
            action.moveToElement(cart).perform();
            String actual = driver.findElement(By.cssSelector("#flyout-cart div.name > a")).getText();
            assertEquals(Expected, actual);
        }

                                                // Checkout
    public void Checkout() {

        // Fill in checkout form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termsofservice"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout"))).click();

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.className("login-button")).click();

        // Verify Checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termsofservice"))).click();
        driver.findElement(By.id("checkout")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-billing .button-1"))).click();

        // Check if shipping info is required or not and fill it in
        if(driver.getPageSource().contains("Shipping address") && (driver.getPageSource().contains("Shipping method"))) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-shipping .button-1"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-shipping_method .button-1"))).click();

        }

        // Continue through rest of checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-payment_method .button-1"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-payment_info .button-1"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-confirm_order .button-1"))).click();

        // Verify checkout was successful
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("strong")));
        String expected = "Your order has been successfully processed!";
        String actual = driver.findElement(By.className("title")).getText().trim();
        assertEquals(expected, actual);
        driver.findElement(By.className("order-completed-continue-button")).click();
        actual  = driver.getTitle();
        expected = "Demo Web Shop";
        assertEquals(expected, actual);


    }


                                                // ACCESSORY
        public void Accessory() {
            this.Expected = "TCP Self-Paced Training";
        }

        public void gotoComputers() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-menu [href=\"/computers\"]"))).click();
        }

        public void gotoAccessories() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(3) > div > h2  > a"))).click();

        }

        public void addtocartAccessory() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(6) > div > div.details input"))).click();
        }


                                                // CAMERA
        public void DSLR() {
            this.Expected = "Digital SLR - Special edition";
        }

        public void gotoElectronics() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-menu > li:nth-child(3) > a"))).click();
        }

        public void gotoCamera() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(1) > div > h2 > a"))).click();
        }

        public void gotoDSLR() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(3) > div > div.details > h2 > a"))).click();
        }

        public void addtocartDSLR_SE() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add-to-cart-button-19"))).click();
        }

                                                // DESKTOP

        public void Desktop() {
            this.Expected = "Build your own expensive computer";
        }

        public void gotoDesktops() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(1) > div > h2  > a"))).click();
        }

        public void gotoExpensiveComputer() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(3) > div > div.details div.buttons > input"))).click();
        }

        public void addtocartExpensiveComputer() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div #add-to-cart-button-74"))).click();
        }

                                                // DIGITAL DOWNLOADS

        public void DigitalDownloads() {
            this.Expected = "Music 2";
        }

        public void gotoDigitalDownloads() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-menu > li:nth-child(5) > a"))).click();
        }

        public void addtocartMusic2() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(3) > div > div.details input"))).click();
        }

                                                // GIFT CARD

        public void GiftCard() {
            this.Expected = "$100 Physical Gift Card";
        }

        public void gotoGiftCards() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-menu > li:nth-child(7) > a"))).click();
        }

        public void goto$100PhysicalGiftCard() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(4) > div > div.details input"))).click();
        }

        public void formGiftCard() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#giftcard_4_RecipientName"))).sendKeys("Joe");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#giftcard_4_SenderName"))).sendKeys("Smith");
        }

        public void addtocart$100PhysicalGiftCard() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add-to-cart-button-4"))).click();
        }

                                                // JEWELRY

        public void Jewelry() {
            this.Expected = "Black & White Diamond Heart";
        }

        public void gotoJewelry() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-menu > li:nth-child(6) > a"))).click();
        }

        public void addtocartBlackWhiteDiamondHeart() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(2) > div > div.details input"))).click();
        }

                                                // NOTEBOOK

        public void Notebook() {
            this.Expected = "14.1-inch Laptop";
        }

        public void gotoNotebooks() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(2) > div > h2  > a"))).click();
        }

        public void addtocart14_1_Laptop() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.add-info input"))).click();
        }

                                                // PHONE COVER

        public void PhoneCover() {
            this.Expected = "Phone Cover";
        }

        public void gotoCellPhones() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(2) > div > h2 > a"))).click();
        }

        public void gotoPhoneCover() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(3) > div > div.details input"))).click();
        }

        public void addtocartPhoneCover() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add-to-cart-button-80"))).click();
        }

                                                // SHOES

        public void Shoes() {
            this.Expected = "Blue and green Sneaker";
        }

        public void gotoApparelShoes() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-menu li:nth-child(4) > a"))).click();
        }

        public void gotoBlueGreenSneaker() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(2) > div > div.details input"))).click();
        }

        public void addtocartBlueGreenSneaker() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add-to-cart-button-28"))).click();
        }

}
