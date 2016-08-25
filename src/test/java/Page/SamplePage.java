package Page;

import Steps.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pranjalt on 23/08/16.
 */
public class SamplePage {

    WebDriver driver;



    By searchBox = By.className("LM6RPg");
    By searchIcon = By.className("vh79eN");


    public SamplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void verifySearchResult(String product) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3liAhj")));
        Assert.assertTrue(driver.findElement(By.className("_3liAhj")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='The Jungle Book (English)']")).isDisplayed());
    }

    public void selectFirstAvailableProduct() {
        driver.findElement(By.className("_3liAhj")).click();
    }

    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3zLR9i _3Plo8Q _19RW-r")));
        driver.findElement(By.className("_3zLR9i _3Plo8Q _19RW-r")).click();
    }

    public void navigateToGoToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3zLR9i _3Plo8Q _19RW-r")));
        driver.findElement(By.className("_3zLR9i _3Plo8Q _19RW-r")).click();
    }
}
