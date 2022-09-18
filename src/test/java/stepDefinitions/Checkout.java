package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utility.Hooks.driver;

public class Checkout {


    WebDriver driver;

    public void setDriver(WebDriver Driver){
        this.driver=Driver;

    }



    // Method 1: Checkout as Registered User
    public void Checkout(WebDriver Driver) throws InterruptedException {
        this.driver=Driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Fill in checkout form
//        driver.findElement(By.id("CountryId")).click();
//        WebElement country = driver.findElement(By.id("CountryId"));
//        Select selectCountry = new Select(country);
//        selectCountry.selectByValue("1");
//        Thread.sleep(2000);
//        driver.findElement(By.id("StateProvinceId")).click();
//        WebElement state = driver.findElement(By.id("StateProvinceId"));
//        Select selectState = new Select(state);
//        selectState.selectByVisibleText("Virginia");
//        driver.findElement(By.id("ZipPostalCode")).sendKeys("23173");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termsofservice"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout"))).click();

        //Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))).sendKeys("smith1212@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password");
        driver.findElement(By.className("login-button")).click();


        //Verify Checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termsofservice"))).click();
        driver.findElement(By.id("checkout")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-billing .button-1"))).click();

        //Check if shipping info is required or not and fill it in
//        boolean ShippingAddress = driver.findElement(By.cssSelector("#opc-shipping")).isDisplayed();
//        boolean ShippingMethod = driver.findElement(By.cssSelector("#opc-shipping_method")).isDisplayed();
        boolean ShippingAddress;
        try {
            driver.findElement(By.cssSelector("#opc-shipping")).isDisplayed();
            ShippingAddress = true;
        }catch (NoSuchElementException ignored){
            ShippingAddress = false;
        }
        if (ShippingAddress) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-shipping .button-1"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-shipping_method .button-1"))).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-payment_method .button-1"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-payment_info .button-1"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-confirm_order .button-1"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("strong")));
          String expected = "Your order has been successfully processed!";
          String actual = driver.findElement(By.className("title")).getText().trim();
          assertEquals(expected, actual);
          driver.findElement(By.className("order-completed-continue-button")).click();
          actual  = driver.getTitle();
          expected = "Demo Web Shop";
          assertEquals(expected, actual);

    }

    // Method 2: Checkout as Guest



}
