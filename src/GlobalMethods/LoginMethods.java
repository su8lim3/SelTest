package GlobalMethods;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.thoughtworks.selenium.*;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

public class LoginMethods {
	
	public boolean SimpleLogin(WebDriver wDriver, String url) throws Exception {
		wDriver.get(url);
		wDriver.findElement(By.linkText("CUSTOMERS")).click();		
		if(wDriver.getTitle() == "Customers"){				
			return true;		
			}		
		return false;				
	}
		

}
