package Steps;


import Page.SamplePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pranjalt on 11/08/16.
 */
public class SampleStep extends DriverFactory{



    @Given("^I navigate to flipkart home page$")
    public void navigate_to_flipkart_home_page() throws Throwable {
    driver.get("http://www.flipkart.com");

    }

    @When("^I search for product \"([^\"]*)\"$")
    public void I_search_for_product(String product) throws Throwable {    // Express the Regexp above with the code you wish you had
        enterProductInSearchBox(product);
    }



    @Then("^I should see the product \"([^\"]*)\" in search result$")
    public void I_should_see_the_product_in_search_result(String product) throws Throwable {
        new SamplePage(driver).verifySearchResult(product);
        }


    @When("^I select First available option$")
    public void I_select_First_available_option() throws Throwable {
        new SamplePage(driver).selectFirstAvailableProduct();
    }

    @When("^add it to shopping cart$")
    public void add_it_to_shopping_cart() throws Throwable {
        new SamplePage(driver).addProductToCart();
    }

    @When("^I Go To Cart$")
    public void Go_To_Cart() throws Throwable {
        new SamplePage(driver).navigateToGoToCart();
    }

    @Then("^selected product \"([^\"]*)\" should get added to cart$")
    public void selected_product_should_get_added_to_cart(String arg1) throws Throwable {

       //verify results

    }

    public void enterProductInSearchBox(String product) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 100);// Express the Regexp above with the code you wish you had
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchIcon).click();
    }

}
