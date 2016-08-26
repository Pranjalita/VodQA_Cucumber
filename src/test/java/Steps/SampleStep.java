package Steps;


import Page.SamplePage;


import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pranjalt on 11/08/16.
 */
public class SampleStep extends DriverFactory {


    @Given("^I navigate to flipkart home page$")
    public void navigate_to_flipkart_home_page() throws Throwable {
        //driver.manage().window().setSize(new Dimension(1204,768));
        driver.manage().window().setSize(new Dimension(1500,1000));
        driver.get("http://www.flipkart.com");


    }

    @When("^I search for product \"([^\"]*)\"$")
    public void I_search_for_product(String product) throws Throwable {    // Express the Regexp above with the code you wish you had
        enterProductInSearchBox(product);
    }


    @Then("^I should see the product \"([^\"]*)\" in search result$")
    public void I_should_see_the_product_in_search_result(String product) throws Throwable {
        verifySearchResult(product);
    }


    @When("^I select First available option$")
    public void I_select_First_available_option() throws Throwable {
        selectFirstAvailableProduct();
    }

    @When("^add it to shopping cart$")
    public void add_it_to_shopping_cart() throws Throwable {
        addProductToCart();
    }

    @When("^I Go To Cart$")
    public void Go_To_Cart() throws Throwable {
        navigateToGoToCart();
    }

    @Then("^I should be able to place order$")
    public void I_should_be_able_to_place_order() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);// Express the Regexp above with the code you wish you had
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("place-order-button")));
       Assert.assertTrue(driver.findElement(By.className("place-order-button")).isDisplayed());
      //  tearDown(driver);
    }


    public void enterProductInSearchBox(String product) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 100);// Express the Regexp above with the code you wish you had
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("LM6RPg")));
        driver.findElement(By.className("LM6RPg")).sendKeys(product);
        driver.findElement(By.className("vh79eN")).click();
    }

    public void verifySearchResult(String product) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_2cLu-l")));
        Assert.assertTrue(driver.findElement(By.className("_2cLu-l")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='The Cucumber Book (English)']")).isDisplayed());
    }

    public void selectFirstAvailableProduct() {
        driver.findElement(By.className("_2cLu-l")).click();
        System.out.println("select product");
    }

    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3zLR9i")));
        driver.findElement(By.className("_3zLR9i")).click();
    }

    public void navigateToGoToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3zLR9i")));
        driver.findElement(By.className("_19RW-r")).click();
       // driver.findElement(By.xpath("//*[contains(@class,'_3zLR9i')]")).click();
    }

@After
    public void tearDown(WebDriver driver)
    {
        driver.close();
        System.out.println("Session Ended");
    }
}
