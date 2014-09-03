package com;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.remote.UnreachableBrowserException;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.SeleneseTestCase;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({LoginTest.class,SleepTest.class,ArchiveTest.class,LogoutTest.class})



public class Setup {
	
	private static boolean flag = false;
	/** The log. */
	private static Log log = LogFactory.getLog(Setup.class);

	/** The driver. */
	public static WebDriver driver;

	/** The element. */
	public WebElement element;

	/** The wait. */
	public static WebDriverWait wait;

	/** The baseUrl. */
	public static String baseUrl;

	/** The browser */
	public static String browser;

	/** The OS **/
	public static String os; 




	/**
	 * Before class.
	 * 
	 * @throws Exception the exception
	 */

	@BeforeClass

	public static void setUpClass() throws Exception{
	    
	    String  computername=InetAddress.getLocalHost().getHostName();
	    
	    baseUrl= System.getProperty("webdriver.base.url");
	    browser=System.getProperty("browser");
	    os=System.getProperty("os.name");
	    if (browser.equalsIgnoreCase("firefox"))
	    {
	  
	        
	     driver=new FirefoxDriver();
	     driver.get(baseUrl);
	    }
	    
	    else if (browser.equalsIgnoreCase("ie"))
	    {/*
	            System.setProperty("webdriver.ie.driver","C:/selenium/IEDriverServer.exe");
	        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
	        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	        true); 
	        driver=new InternetExplorerDriver(dc);
	        LoginTest.driver.get(baseUrl);
	        Thread.sleep(10000);
	        */
	        System.out.println("Please use firefox or chrome browsers");
	        
	        
	    }
	    else if (browser.equalsIgnoreCase("chrome"))
	    {
	        
	        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        String[] switches = { "--ignore-certificate-error", "--disable-popup-blocking", "--disable-translate", "--allow-running-insecure-content"};
	        dc.setCapability("chrome.switches", Arrays.asList(switches));
	        
	        driver = new ChromeDriver(dc);
	        driver.get(baseUrl);
	        Thread.sleep(10000);
	        
	    }
	    else
	    {
	        Setup.log.error("Invalid browser");
	    }
	    
	    
	    Setup.log.info("====================================================");
	    Setup.log.info("Beginning of Execution ");
	    Setup.log.info("====================================================");
	    Setup.log.info("/********************HEADER****************************");

	    
	        Setup.log.info("TARGET SYSTEM :" +baseUrl);
	        if(baseUrl.contains("dev"))
	        {
	            Setup.log.info("ENVIRONMENT : DEV ENVIRONMENT");
	        
	        }
	        else if (baseUrl.contains("int"))
	        {
	            Setup.log.info("ENVIRONMENT : INT ENVIRONMENT");
	            
	        }
	        else if(baseUrl.contains("net"))
	        {
	            Setup.log.info("ENVIRONMENT : PROD ENVIRONMENT");
	        }
	    
	     if(browser.equalsIgnoreCase("firefox"))
	    {
	    Setup.log.info("BROWSER: FireFox");
	    }
	    else if (browser.equalsIgnoreCase("ie"))
	    {
	        Setup.log.info("BROWSER : InternetExplorer");
	    }
	    else if (browser.equalsIgnoreCase("chrome"))
	    {
	        Setup.log.info("BROWSER : CHROME");
	    }
	    else
	    {
	        Setup.log.info("Invalid browser");
	    }
	     Setup.log.info("OPERATING SYSTEM : " +os);
	     Setup.log.info("SYSTEM EXECUTING THE TEST SUITE : " +computername);
	    
	     
	     Setup.log.info("*****************************************************/");
	    flag=true;
	    
	    }



	@AfterClass
	public static void tearDownClass()
	{
	    driver.quit();
	}
}
