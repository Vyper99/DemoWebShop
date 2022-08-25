package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Checkout {

    WebDriver driver;

    public void setDriver(WebDriver Driver){
        this.driver=Driver;

    }

    // Method 1: Checkout as Registered User
    public void Checkout() throws InterruptedException {

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
        String expected = "Checkout";
        String actual = driver.findElement(By.className("page-title")).getText();
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

    // Method 2: Checkout as Guest



}
