package Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by eloy51305 on 9/9/2014.
 */
public class TestMethods {

    public void ClickAround(WebDriver wDriver){
        wDriver.findElement(By.linkText("JavaScript")).click();
        wDriver.findElement(By.cssSelector("p > a")).click();
        Assert.assertEquals("bootstrap/bower.json at v3.2.0 · twbs/bootstrap · GitHub", wDriver.getTitle());

    }

}
