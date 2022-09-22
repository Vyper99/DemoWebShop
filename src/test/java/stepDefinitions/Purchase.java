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


public class Purchase {

    PurchasePage purchase = PageFactory.initElements(driver, PurchasePage.class);


    // ACCESSORY
    @When("User Adds TCP Self-paced Training To Cart")
    public void user_adds_tcp_self_paced_training_to_cart() {

        // Set Expected String When Checking Cart
            purchase.Accessory();

        // Go to DemoWebShop Homepage
            purchase.homePage();

        // Find Accessory & Add To Cart
            purchase.gotoComputers();
            purchase.gotoAccessories();
            purchase.addtocartAccessory();

    }


    // Verify Item Is In Cart
    @Then("Verify Item Is In Cart")
    public void verify_item_is_in_cart() {

        // Verify Item Is In Cart Using verifyCart
            purchase.verifyCart();

    }

    @Then("Checks out Successfully")
    public void checks_out_successfully() throws InterruptedException {

        // Go To Cart
            purchase.gotoCart();

        // Use Checkout method to complete Checkout
//            Checkout checkout = new Checkout();
//            checkout.Checkout(driver);
              purchase.Checkout();
    }

    // CAMERA

    @When("User Adds DSLR Special Edition Camera To Cart")
    public void user_adds_dslr_special_edition_camera_to_cart() {

        // Set Expected String When Checking Cart
        purchase.DSLR();

        // Go to DemoWebShop Homepage
        purchase.homePage();

        // Find DSLR Special Edition Camera & Add To Cart
        purchase.gotoElectronics();
        purchase.gotoCamera();
        purchase.gotoDSLR();
        purchase.addtocartDSLR_SE();

    }

    // DESKTOP

    @When("User Adds Desktop to Cart")
    public void user_adds_desktop_to_cart() {

        // Set Expected String When Checking Cart
        purchase.Desktop();

        // Go to DemoWebShop Homepage
        purchase.homePage();

        // Find Expensive Computer & Add To Cart
        purchase.gotoComputers();
        purchase.gotoDesktops();
        purchase.gotoExpensiveComputer();
        purchase.addtocartExpensiveComputer();

    }

    // DIGITAL DOWNLOADS

    @When("User Adds music2 Under digital downloads To Cart")
    public void user_adds_music2_under_digital_downloads_to_cart() {

        // Set Expected String When Checking Cart
        purchase.DigitalDownloads();

        // Go to DemoWebShop Homepage
        purchase.homePage();

        // Find Music 2 & Add To Cart
        purchase.gotoDigitalDownloads();
        purchase.addtocartMusic2();

    }

    // GIFT CARD

    @When("User Adds Gift Card To Cart")
    public void user_adds_gift_cart_to_cart() {

        // Set Expected String When Checking Cart
        purchase.GiftCard();

        // Go to DemoWebShop Homepage
        purchase.homePage();

        // Find Gift Card & Add To Cart
        purchase.gotoGiftCards();
        purchase.goto$100PhysicalGiftCard();
        purchase.formGiftCard();
        purchase.addtocart$100PhysicalGiftCard();


    }

    // JEWELRY

    @When("User Adds Jewelry To Cart")
    public void user_adds_jewelry_to_cart() {

        // Set Expected String When Checking Cart
        purchase.Jewelry();

        // Go to DemoWebShop Homepage
        purchase.homePage();

        // Find Jewelry & Add To Cart
        purchase.gotoJewelry();
        purchase.addtocartBlackWhiteDiamondHeart();

    }

    // NOTEBOOK

    @When("User Adds Laptop to Cart")
    public void user_adds_laptop_to_cart() {

        // Set Expected String When Checking Cart
        purchase.Notebook();

        // Go to DemoWebShop Homepage
        purchase.homePage();

        // Find Notebook Computer & Add To Cart
        purchase.gotoComputers();
        purchase.gotoNotebooks();
        purchase.addtocart14_1_Laptop();

    }

    // PHONE COVER

    @When("User Adds Cell Phone Cover to Cart")
    public void user_adds_cell_phone_to_cart() {

        // Set Expected String When Checking Cart
        purchase.PhoneCover();

        // Go to DemoWebShop Homepage
        purchase.homePage();

        // Find Phone Cover & Add To Cart
        purchase.gotoElectronics();
        purchase.gotoCellPhones();
        purchase.gotoPhoneCover();
        purchase.addtocartPhoneCover();


    }

    // SHOES

    @When("User Adds Blue and green Sneaker to Cart")
    public void user_adds_blue_and_green_sneaker_to_cart() {

        // Set Expected String When Checking Cart
        purchase.Shoes();

        // Go to DemoWebShop Homepage
        purchase.homePage();

        // Find Blue and green Sneaker & Add To Cart
        purchase.gotoApparelShoes();
        purchase.gotoBlueGreenSneaker();
        purchase.addtocartBlueGreenSneaker();

    }





}
