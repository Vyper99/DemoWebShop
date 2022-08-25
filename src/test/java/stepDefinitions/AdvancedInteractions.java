package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static utility.Hooks.driver;

public class AdvancedInteractions {


    @Given("Customer is on Demo Web Shop")
    public void customer_is_on_demo_web_shop() {
        driver.get("https://demowebshop.tricentis.com");


    }
    @When("Customer hovers over Computers section")
    public void customer_hovers_over_computers_section() throws InterruptedException {
        WebElement computers = driver.findElement(By.cssSelector(".top-menu [href=\"/computers\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(computers).perform();
        Thread.sleep(10000);

    }
    @Then("Customer should see Desktop Section")
    public void customer_should_see_desktop_section() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("health book is in shopping cart")
    public void health_book_is_in_shopping_cart() throws InterruptedException {
        //search for book on home page
        driver.get("https://demowebshop.tricentis.com");
        driver.findElement(By.name("q")).sendKeys("book", Keys.ENTER);
        Thread.sleep(2000);

        //add book to cart
        String expected = "Health Book";
        String actual = driver.findElement(By.className("product-title")).getText().trim();
        assertEquals(expected, actual);
        driver.findElement(By.className("product-box-add-to-cart-button")).click();
        Thread.sleep(2000);



    }
    @When("customer hovers over shopping cart")
    public void customer_hovers_over_shopping_cart() throws InterruptedException {
        WebElement cart=driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));
        Actions action = new Actions(driver);
        action.moveToElement(cart).perform();
        Thread.sleep(2000);





    }
    @Then("customer should see Health Book in shopping cart")
    public void customer_should_see_health_book_in_shopping_cart() {
        String expected = "Health Book";
        String actual = driver.findElement(By.cssSelector("#flyout-cart div.name > a")).getText();
        assertEquals(expected, actual);


    }


    @Given("Customer on drag and drop page")
    public void customer_on_drag_and_drop_page() {
        driver.get("https://formy-project.herokuapp.com/dragdrop");

    }
    @When("Customer drags picture and drops in the box")
    public void customer_drags_picture_and_drops_in_the_box() throws InterruptedException {
        Actions actions=new Actions(driver);
        WebElement source = driver.findElement(By.cssSelector("#image"));
        WebElement target = driver.findElement(By.cssSelector("#box"));
//        System.out.println(target.getText());
        actions.dragAndDrop(source, target).perform();
//        System.out.println(target.getText());
        Thread.sleep(1000);


    }
    @Then("Customer should get success message")
    public void customer_should_get_success_message() {
        String actual = driver.findElement(By.cssSelector("#box")).getText().trim();
        String expected = "Dropped!";
        assertEquals(expected, actual);

    }

    @Given("Customer on file upload page")
    public void customer_on_file_upload_page() {
        driver.get("https://formy-project.herokuapp.com/fileupload");

    }

    @When("Customer uploads a file")
    public void customer_uploads_a_file() throws InterruptedException {
        WebElement fileUpload=driver.findElement(By.cssSelector("#file-upload-field"));
        String filePath = "/TechInsider SDET/getOptions.png";
        fileUpload.sendKeys(filePath);
        Thread.sleep(2000);

    }

    @Then("File should be uploaded")
    public void file_should_be_uploaded() {

    }

    @Given("Customer on Scrolling Page")
    public void customer_on_scrolling_page() {
        driver.get("https://formy-project.herokuapp.com/scroll");

    }
    @When("Customer scrolls down to the bottom of the page")
    public void customer_scrolls_down_to_the_bottom_of_the_page() throws InterruptedException {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(2000);

    }

    @Given("Customer on Alert Page")
    public void customer_on_alert_page() {
        driver.get("https://formy-project.herokuapp.com/switch-window");

    }
    @When("Customer clicks on alert")
    public void customer_clicks_on_alert() throws InterruptedException {
        driver.findElement(By.cssSelector("alert-button")).click();
        Thread.sleep(2000);

    }
    @Then("Customer should get alert window")
    public void customer_should_get_alert_window() throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        String expected = "This is a test alert!";
        assertEquals(expected, actual);
        alert.dismiss();
        Thread.sleep(2000);



    }

}
