package GlobalMethods;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import com.thoughtworks.selenium.*;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

/**
 * Created by eloy51305 on 9/8/2014.
 */
public class DriverSetup {

    private WebDriver driver;

    public enum BrowserType{
        FIREFOX, IE, CHROME, ANDROID, SAFARI
    }

    public WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                driver = new FirefoxDriver();
                return  driver;
            
            case IE:
                String ieDriverPath = "/path/to/ieDriver";
                DesiredCapabilities ieCapability = DesiredCapabilities.internetExplorer();
                System.setProperty("webdriver.ie.driver", ieDriverPath);
                driver = new InternetExplorerDriver(ieCapability);
                driver = new ChromeDriver();
                return driver;

            case CHROME:
                String chromeDriverPath = "/path/to/chromedriver";
                DesiredCapabilities chromeCapability = DesiredCapabilities.chrome();
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                WebDriver driver = new ChromeDriver(chromeCapability);
                driver = new ChromeDriver();
                return driver;

            //case SAFARI:
                // Need to implement
                //return driver;

            //case ANDROID:
                // Need to implement
                //return driver;

            default:
                throw new RuntimeException("Browser type unsupported");
        }
    }
}
