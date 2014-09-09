package Tests;

import com.Setup;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import GlobalMethods.DriverSetup;

/**
 * Created by eloy51305 on 9/9/2014.
 */
public class TestDriver {

    static DriverSetup sDriver = new DriverSetup();
    public static WebDriver wDriver;

    @BeforeClass
    public static void setUp() throws Exception {

        wDriver = sDriver.getDriver(DriverSetup.BrowserType.FIREFOX);
        String baseUrl = "http://getbootstrap.com/";
        wDriver.get(baseUrl);
        wDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wDriver.manage().window().maximize();
    }

    @Test
    public void ClickAround(){
        wDriver.findElement(By.linkText("JavaScript")).click();
        wDriver.findElement(By.cssSelector("p > a")).click();
        Assert.assertEquals("bootstrap/bower.json at v3.2.0 · twbs/bootstrap · GitHub", wDriver.getTitle());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        wDriver.quit();
    }


}
