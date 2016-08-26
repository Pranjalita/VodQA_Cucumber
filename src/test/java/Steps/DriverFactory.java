package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    WebDriver driver;
    WebDriverWait wait;



    public DriverFactory(){
        System.setProperty("webdriver.chrome.driver", "/Users/pranjalt/Downloads/chromedriver");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 100);
    }

    public void tearDown(WebDriver driver)
    {
        driver.quit();
        System.out.println("Session Ended");
    }


}
