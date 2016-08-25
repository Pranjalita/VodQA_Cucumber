package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pranjalt on 23/08/16.
 */
public class DriverFactory {

    WebDriver driver = new FirefoxDriver();


    public WebDriverWait wait = new WebDriverWait(driver, 100);

    public void tearDown(WebDriver driver)
    {
        driver.quit();
        System.out.println("Session Ended");
    }


}
