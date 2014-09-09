package Tests;

import com.Setup;
import org.apache.http.util.ExceptionUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import GlobalMethods.DriverSetup;
import org.openqa.selenium.remote.SessionNotFoundException;

/**
 * Created by eloy51305 on 9/9/2014.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDriver {

    static DriverSetup sDriver = new DriverSetup();
    static TestMethods tMethods = new TestMethods();
    public static WebDriver wDriver;

    @BeforeClass
    public static void setUp(){

        wDriver = sDriver.getDriver(DriverSetup.BrowserType.FIREFOX);
        String baseUrl = "http://getbootstrap.com/";
        wDriver.get(baseUrl);
        wDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wDriver.manage().window().maximize();
    }

    @Test
    public void aClickAround(){
        tMethods.aClickAround(wDriver);

    }

    @Test
    public void bClickAround(){
        wDriver.navigate().back();
        tMethods.bClickAround(wDriver);
        wDriver.quit();
    }

    @Test
    public void cClickAround(){
        try {

            tMethods.cClickAround(wDriver);

        } catch (SessionNotFoundException e){
            setUp();
            cClickAround();
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        wDriver.quit();
    }
}
