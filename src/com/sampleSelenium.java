package com;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.thoughtworks.selenium.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class sampleSelenium {
	
	 private static WebDriver driver;
	 private static String baseUrl;
	 private boolean acceptNextAlert = true;
	 private StringBuffer verificationErrors = new StringBuffer();
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void _01testAdvancedSearch() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("gbqfq")).clear();
	    driver.findElement(By.id("gbqfq")).sendKeys("test automation");
	    driver.findElement(By.id("gbqfb")).click();

	}

	@Test
	public void _02testLanguageTools() throws Exception {
	    driver.findElement(By.cssSelector("a.q.qs")).click();
	    try {
	        assertTrue(isElementPresent(By.id("smb")));
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }


	}

	@Test
	public void _03testAdvertisingPrograms() throws Exception {
	    driver.findElement(By.xpath("//a[contains(text(),'News')]")).click();

	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	

}
