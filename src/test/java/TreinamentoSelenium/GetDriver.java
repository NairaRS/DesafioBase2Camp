package TreinamentoSelenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class GetDriver {
    protected final WebDriver driver; // protected allows for subclasses to access

    public GetDriver() {
        if(System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\naira\\Downloads\\chromedriver.exe");
        }
        this.driver = new ChromeDriver();
    }
    public WebDriver getDriver(){
        return driver;
    }
}
