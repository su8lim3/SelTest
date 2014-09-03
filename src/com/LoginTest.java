/*******************************************************************************
 * Copyright (c) 2006 - 2012, OXSEED AG, All rights reserved.
 * 
 * @author Anitha
 ******************************************************************************/

package com;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.remote.UnreachableBrowserException;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
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





/**
 * The Class LoginTest.
 */
public class LoginTest extends SeleneseTestBase{
	
	private static Log log = LogFactory.getLog(LoginTest.class);

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

     * Stop the standard test setUp from being processed as we only want to start the browser at the start of the suite

     * Intentially blank to override default setUp() functionality

     */
    @Override
    @Before

    public void setUp()
    {
    }
    
    @Override
    @After
    /**

     * Stop the standard test tearDown from being processed as we only want to stop the browser at the end of the suite

     * Intentially blank to override default tearDown() functionality

     */
    public void tearDown()
    {}
	/**
	 * Before class.
	 * 
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setupClass() throws Exception{
		String  computername=InetAddress.getLocalHost().getHostName();
		
		baseUrl= System.getProperty("webdriver.base.url");
		browser=System.getProperty("browser");
		os=System.getProperty("os.name");
		if (browser.equalsIgnoreCase("firefox"))
		{
      
			
		 driver=new FirefoxDriver();
		 LoginTest.driver.get(baseUrl);
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
			LoginTest.driver.get(baseUrl);
			Thread.sleep(10000);
			
		}
		else
		{
			log.error("Invalid browser");
		}
		
		
		log.info("====================================================");
		log.info("Beginning of Execution ");
		log.info("====================================================");
		log.info("/********************HEADER****************************");
	
	    
	    	log.info("TARGET SYSTEM :" +baseUrl);
	    	if(baseUrl.contains("dev"))
			{
				log.info("ENVIRONMENT : DEV ENVIRONMENT");
			
			}
			else if (baseUrl.contains("int"))
			{
				log.info("ENVIRONMENT : INT ENVIRONMENT");
				
			}
			else if(baseUrl.contains("net"))
			{
				log.info("ENVIRONMENT : PROD ENVIRONMENT");
			}
	    
	     if(browser.equalsIgnoreCase("firefox"))
	    {
	    log.info("BROWSER: FireFox");
	    }
	    else if (browser.equalsIgnoreCase("ie"))
		{
			log.info("BROWSER : InternetExplorer");
		}
	    else if (browser.equalsIgnoreCase("chrome"))
	    {
	    	log.info("BROWSER : CHROME");
	    }
		else
		{
			log.info("Invalid browser");
		}
	     log.info("OPERATING SYSTEM : " +os);
	     log.info("SYSTEM EXECUTING THE TEST SUITE : " +computername);
	    
	     
	     log.info("*****************************************************/");
		}



	/**
	 * Logincase.
	 * 
	 * @throws Exception the exception
	 */
	@Test
	public void logincase() throws Exception , UnreachableBrowserException{
		try
		{
			
		// Login
			LoginTest.log.info("---------------------------------------------");
			LoginTest.log.info("Testcase : DEV-222 Login ");
			LoginTest.log.info("---------------------------------------------");
		
			LoginTest.driver.switchTo().window("OxseedDesktopWindow");
		//Assert.assertEquals("Pop Window Title is:", "Oxseed Desktop", LoginTest.driver.getTitle());
		LoginTest.log.info("Switching to Popup Window success");
		
		LoginTest.wait = new WebDriverWait(LoginTest.driver, 600);
		LoginTest.wait.until(visibilityOfElementLocated(By.id("loginviewport__Logindhtmlx_w_dhtmlx_f")));
		final WebElement frame = LoginTest.driver.findElement(By.id("loginviewport__Logindhtmlx_w_dhtmlx_f"));
		Assert.assertNotNull(frame);
		LoginTest.driver.switchTo().frame(frame);
		LoginTest.log.info("Login Frame Selected");
		LoginTest.wait.until(visibilityOfElementLocated(By.id("logon_text")));
		WebElement username, pwd;
		username = checkIdLoaded("UserId");
		pwd = checkIdLoaded("Passwort");
		if (username != null && pwd != null) {
			if(baseUrl.contains("dev"))
			{
				
			LoginTest.driver.findElement(By.id("UserId")).sendKeys("ani22062012");
			LoginTest.driver.findElement(By.id("Passwort")).sendKeys("mht");
			}
			else if (baseUrl.contains("int"))
			{
				
				LoginTest.driver.findElement(By.id("UserId")).sendKeys("ani26062012");
				LoginTest.driver.findElement(By.id("Passwort")).sendKeys("mht");
			}
			else if (baseUrl.contains("net"))
			{
				LoginTest.driver.findElement(By.id("UserId")).sendKeys("testauto");
				LoginTest.driver.findElement(By.id("Passwort")).sendKeys("mht");
			}
		}
		Assert.assertNotNull(LoginTest.driver.findElement(By.id("logon_text")));
        Thread.sleep(8000);        
		LoginTest.driver.findElement(By.id("logon_text")).click();
		LoginTest.log.info("Login Success");
		Assert.assertNotNull(LoginTest.driver.switchTo().defaultContent());
		LoginTest.log.info("DEV-222 Testcase successs");

		// Start page Elements
        LoginTest.log.info("--------------------------------------------------");
        LoginTest.log.info("Test Case: Checking Elements On Start page");
        LoginTest.log.info("--------------------------------------------------");
		// welcome note
		WebElement welcomenote, menuview, workbasketview, savedsearch;
		welcomenote = checkApplicationLoaded("span[paneltitle=\"welcome\"] iframe.seedcontent");
		Assert.assertNotNull(welcomenote);
		if(welcomenote!=null)
		{
		LoginTest.log.info("welcome note panel element present");
		}
		else
		{
			LoginTest.log.error(welcomenote);
		}

		// menu view
		menuview = checkApplicationLoaded("span[paneltitle=\"menuview\"] iframe.seedcontent");
		Assert.assertNotNull(menuview);
		if(menuview!=null)
		{
		LoginTest.log.info("Applications panel element present");
		}
		else
		{
			LoginTest.log.error(menuview);
		}

		// work basket view
		workbasketview = checkApplicationLoaded("span[paneltitle=\"workbasketmenuview\"] iframe.seedcontent");
		Assert.assertNotNull(workbasketview);
		LoginTest.log.info("Workbaskets panel element present");

		// saved searches

		savedsearch = checkApplicationLoaded("span[paneltitle=\"savedsearchs\"] iframe.seedcontent");
		Assert.assertNotNull(savedsearch);
		LoginTest.log.info("Saved Searches panel element present");

		final WebElement frame1 = LoginTest.driver.findElement(By.cssSelector("span[paneltitle=\"workbasketmenuview\"] iframe.seedcontent"));
		LoginTest.driver.switchTo().frame(frame1);
		LoginTest.log.info("workbaskets list panel selected");
		final WebElement content = checkApplicationLoaded("div.objbox");
		Assert.assertNotNull(content);
		LoginTest.log.info("-----------------------------------------------");
        LoginTest.log.info("Test Case: Opening a workbasket");
        LoginTest.log.info("-----------------------------------------------");
		WebElement inboxgrid;
		inboxgrid = checkElementWithGivenText("Inbox");
		Assert.assertNotNull(inboxgrid);
		inboxgrid.click();
		LoginTest.log.info("inbox grid clicked");
        LoginTest.driver.switchTo().defaultContent();
        LoginTest.log.info("switch to the current view");

		// work basket elements check
        
		WebElement wb, wb_content;
		wb = checkApplicationLoaded("span[paneltitle=\"workbasketapp\"] iframe.seedcontent");
		Assert.assertNotNull(wb);
		LoginTest.driver.switchTo().frame(wb);
		LoginTest.log.info("switching success");

		wb_content = checkApplicationLoaded("div.objbox");
		Assert.assertNotNull(wb_content);
		LoginTest.log.info("work basket loaded");
		System.out.println("==============================================================");
		System.out.println("WORKBASKET LOADED");
		System.out.println("==============================================================");

		final WebElement chk = LoginTest.wait.until(visibilityOfElementLocated(By.id("IL0_0_chkall")));
		Assert.assertNotNull(chk);
		chk.click();

		// Forward operation
		LoginTest.log.info("------------------------------------------");
        LoginTest.log.info("Test Case: Forward Operation");
        LoginTest.log.info("------------------------------------------");
		final WebElement wbactions = checkIdLoaded("selectedtext");
		Assert.assertNotNull(wbactions);
		wbactions.click();

		WebElement forward, arrow, forward_dialog, forward_btn, forward_content,forward_content1, storage_grid,strike_out;
		forward = LoginTest.driver.findElement(By.id("forward"));
		forward.click();
		arrow = LoginTest.driver.findElement(By.id("sselect"));
		arrow.click();
		LoginTest.driver.switchTo().defaultContent();

		forward_dialog = checkXpathLoaded("//*[contains(@id,'Weiterleitendhtmlx_w_dhtmlx_f')]");
		LoginTest.driver.switchTo().frame(forward_dialog);
		LoginTest.log.info("Switching success..");
		
        Thread.sleep(8000);
		forward_content = checkApplicationLoaded("div.objbox");
		Assert.assertNotNull(forward_content);
		forward_content1=checkApplicationLoaded("table.obj");
		Assert.assertNotNull(forward_content1);
		forward_btn = checkIdLoaded("done_text");
		Assert.assertNotNull(forward_btn);
		
		
		storage_grid = checkElementWithGivenText("Storage");
		Assert.assertNotNull(storage_grid);
		storage_grid.click();

		LoginTest.log.info("selected..");
		forward_btn.click();
		LoginTest.log.info("forward done");
		LoginTest.driver.switchTo().defaultContent();
		LoginTest.driver.switchTo().frame(wb);
		Thread.sleep(8000);

		strike_out = checkXpathLoaded("//*[@id='WorkbasketApp:IF:0:IL:0:IR_errorSpan']/img");
		Assert.assertNotNull(strike_out);
		LoginTest.log.info("forward operation successfully completed");
		System.out.println("==============================================================");
		System.out.println("FORWARD SUCCESS");
		System.out.println("==============================================================");

		 //change of work basket
		LoginTest.log.info("-----------------------------------------------");
        LoginTest.log.info("Test Case: Change Of Workbasket");
        LoginTest.log.info("-----------------------------------------------");
		WebElement dropdown,dropdownlist,storage;
		dropdown=checkXpathLoaded("//*[@id='dhx_combo_img']");
		Assert.assertNotNull(dropdown);
		dropdown.click();
		dropdownlist=checkApplicationLoaded("div.dhx_combo_list");
		Assert.assertNotNull(dropdownlist);
		LoginTest.log.info("dropdown list loaded");
		storage=driver.findElement(By.xpath("//*[contains(text(),'Storage')]"));
		Assert.assertNotNull(storage);
		storage.click();
		LoginTest.log.info("Storage workbasket selected");
		LoginTest.driver.switchTo().defaultContent();
		
		WebElement chkall,wboperations,sbk,strike_out1;
		final WebElement loading;
		
		loading=checkApplicationLoaded("span[paneltitle=\"workbasketapp\"] span.overlay");
		if(loading.isDisplayed())
		{
		wait.until(new ExpectedCondition<Boolean>(){
		public Boolean apply(WebDriver webdriver)
		{
			System.out.println("waiting..");
			return!(loading.isDisplayed());
		}
	});
		}
		LoginTest.log.info("workbasket loaded");
		System.out.println("==============================================================");
		System.out.println("CHANGE OF WORKBASKET SUCCESS");
		System.out.println("==============================================================");
		
	
		
		//Send back
		LoginTest.log.info("-----------------------------------------------");
        LoginTest.log.info("Test Case: Send back Operation");
        LoginTest.log.info("-----------------------------------------------");
		WebElement wbcon,contents,arrow1;
		LoginTest.log.info("Storage loaded");
		wbcon=wait.until(visibilityOfElementLocated(By.cssSelector("span[paneltitle=\"workbasketapp\"] iframe.seedcontent")));
		Assert.assertFalse(wbcon.getAttribute("style").contains("visibility: hidden"));
		LoginTest.driver.switchTo().frame(wbcon);
		Assert.assertNotNull(wbcon);
		LoginTest.log.info("frame selected");
		contents=wait.until(visibilityOfElementLocated(By.cssSelector("div.objbox")));
		Assert.assertFalse(contents.getAttribute("style").contains("visibility: hidden"));
		Assert.assertNotNull(contents);
		chkall=checkIdLoaded("IL0_0_chkall");
		chkall.click();
		LoginTest.log.info("check box clicked");
		wboperations=checkIdLoaded("selectedtext");
		wboperations.click();
		LoginTest.log.info("drop-up menu clicked");
		sbk=wait.until(visibilityOfElementLocated(By.id("sendback")));
		Assert.assertNotNull(sbk);
		sbk.click();
		arrow1=LoginTest.driver.findElement(By.id("sselect"));
		arrow1.click();
		LoginTest.log.info("sendback done");
		Thread.sleep(8000);
		strike_out1 = wait.until(visibilityOfElementLocated(By.xpath("//*[@id='WorkbasketApp:IF:0:IL:0:IR_errorSpan']/img")));
		Assert.assertNotNull(strike_out1);
		LoginTest.log.info("Send Back successfully completed");
		System.out.println("==============================================================");
		System.out.println("SEND BACK SUCCESS");
		System.out.println("==============================================================");
		
	
		//change Work  basket
		LoginTest.log.info("------------------------------------------------");
        LoginTest.log.info("Test Case: Change Of Workbasket");
        LoginTest.log.info("------------------------------------------------");
		WebElement dropdown1,dropdownlist1,inbox;
		dropdown1=checkXpathLoaded("//*[@id='dhx_combo_img']");
		Assert.assertNotNull(dropdown);
		dropdown1.click();
		dropdownlist1=checkApplicationLoaded("div.dhx_combo_list");
		Assert.assertNotNull(dropdownlist1);
		LoginTest.log.info("dropdown list loaded");
		inbox=LoginTest.driver.findElement(By.xpath("//*[contains(text(),'Inbox')]"));
		Assert.assertNotNull(inbox);
		inbox.click();
		LoginTest.log.info("Inbox workbasket selected");
		LoginTest.driver.switchTo().defaultContent();
		
	
	  final WebElement loading1;
		
		loading1=checkApplicationLoaded("span[paneltitle=\"workbasketapp\"] span.overlay");
		if(loading1.isDisplayed())
		{
			wait.until(new ExpectedCondition<Boolean>(){
				public Boolean apply(WebDriver webdriver)
				{
					System.out.println("waiting..");
					return!(loading1.isDisplayed());
				}
			});
		}
		LoginTest.log.info("workbasket changed");
    
		WebElement wbcon1,contents1;
		wbcon1=wait.until(visibilityOfElementLocated(By.cssSelector("span[paneltitle=\"workbasketapp\"] iframe.seedcontent")));
		Assert.assertFalse(wbcon1.getAttribute("style").contains("visibility: hidden"));
		LoginTest.driver.switchTo().frame(wbcon1);
		Assert.assertNotNull(wbcon1);
		LoginTest.log.info("frame selected");
		contents1=wait.until(visibilityOfElementLocated(By.cssSelector("div.objbox")));
		Assert.assertFalse(contents1.getAttribute("style").contains("visibility: hidden"));
		Assert.assertNotNull(contents1);
		LoginTest.log.info("workbasket loaded");
		System.out.println("==============================================================");
		System.out.println("CHANGE OF WORKBASKET SUCCESS");
		System.out.println("==============================================================");
		
		//logout
		LoginTest.log.info("--------------------------------------------------");
        LoginTest.log.info("Test Case: Logging out");
        LoginTest.log.info("---------------------------------------------------");
		LoginTest.driver.switchTo().defaultContent();
		WebElement logout,frm;
		logout=LoginTest.driver.findElement(By.id("oxseedlogout"));
		Assert.assertNotNull(logout);
		logout.click();
		LoginTest.driver.switchTo().defaultContent();
		frm=LoginTest.wait.until(visibilityOfElementLocated(By.id("loginviewport__Logindhtmlx_w_dhtmlx_f")));
		Assert.assertNotNull(frm);
		LoginTest.driver.switchTo().frame(frm);
		LoginTest.wait.until(visibilityOfElementLocated(By.id("UserId")));
		LoginTest.wait.until(visibilityOfElementLocated(By.id("Passwort")));
		LoginTest.wait.until(visibilityOfElementLocated(By.id("logon_text")));
		LoginTest.log.info("Successfully Logged Out..");
		System.out.println("==============================================================");
		System.out.println("LOGOUT SUCCESS");
		System.out.println("==============================================================");
		
		LoginTest.log.info("=========================================================");
		LoginTest.log.info("End of Execution ");
		LoginTest.log.info("=========================================================");
		}
		catch (Exception e)
		{
			LoginTest.log.error(e);
		}
	}
		

	// Additional methods required

	/**
	 * Visibility of element located.
	 * 
	 * @param locator the locator
	 * 
	 * @return the expected condition< web element>
	 */
	public ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				final WebElement toReturn = driver.findElement(locator);
				if (toReturn.isDisplayed()) {
					return toReturn;
				}
				return null;
			}
		};
	}
	
	
	// css locator

	/**
	 * Gets the css selector element.
	 * 
	 * @param cssSelectorInfo the css selector info
	 * 
	 * @return the css selector element
	 */
	private WebElement getCssSelectorElement(String cssSelectorInfo) {
		WebElement element = null;
		// WebDriverWait wait = new WebDriverWait(driver, 60);
		element = LoginTest.wait.until(visibilityOfElementLocated(By.cssSelector(cssSelectorInfo)));
		return element;
	}

	/**
	 * Check application loaded.
	 * 
	 * @param applicationPanelInfo the application panel info
	 * 
	 * @return the web element
	 */
	private WebElement checkApplicationLoaded(String applicationPanelInfo) {
		WebElement element = null;
		element = getCssSelectorElement(applicationPanelInfo);
		element = LoginTest.driver.findElement(By.cssSelector(applicationPanelInfo));
		return element;

	}

	// id locator

	/**
	 * Gets the id.
	 * 
	 * @param idInfo the id info
	 * 
	 * @return the id
	 */
	private WebElement getid(String idInfo) {
		WebElement element = null;
		// WebDriverWait wait = new WebDriverWait(driver, 60);
		element = LoginTest.wait.until(visibilityOfElementLocated(By.id(idInfo)));
		return element;
	}

	/**
	 * Check id loaded.
	 * 
	 * @param applicationIdInfo the application id info
	 * 
	 * @return the web element
	 */
	private  WebElement checkIdLoaded(String applicationIdInfo) {
		WebElement element = null;
		element = getid(applicationIdInfo);
		element = LoginTest.driver.findElement(By.id(applicationIdInfo));
		return element;

	}

	// xpath locator
	/**
	 * Gets the xpath.
	 * 
	 * @param xpathInfo the xpath info
	 * 
	 * @return the xpath
	 */
	private WebElement getXpath(String xpathInfo) {
		WebElement element = null;
		// WebDriverWait wait = new WebDriverWait(driver, 60);
		element = LoginTest.wait.until(visibilityOfElementLocated(By.xpath(xpathInfo)));
		return element;
	}

	/**
	 * Check xpath loaded.
	 * 
	 * @param applicationxpathInfo the applicationxpath info
	 * 
	 * @return the web element
	 */
	private WebElement checkXpathLoaded(String applicationxpathInfo) {
		WebElement element = null;
		element = getXpath(applicationxpathInfo);
		element = LoginTest.driver.findElement(By.xpath(applicationxpathInfo));
		return element;

	}

	/**
	 * Check element with given text.
	 * 
	 * @param givenTextPar the given text par
	 * 
	 * @return the web element
	 */
	private WebElement checkElementWithGivenText(String givenTextPar) {
		final WebElement table = LoginTest.driver.findElement(By.tagName("table"));
		final List<WebElement> rows = table.findElements(By.tagName("tr"));
		final Iterator<WebElement> i = rows.iterator();
		while (i.hasNext()) {
			final WebElement row = i.next();
			final List<WebElement> columns = row.findElements(By.tagName("td"));
			final Iterator<WebElement> j = columns.iterator();
			while (j.hasNext()) {
				final WebElement column = j.next();
				// System.out.print(column.getText());
				if (column.getText().equalsIgnoreCase(givenTextPar)) {
					return column;
				}
			}
		}
		return null;

	}
	public String getAlert() { 
		Alert alert = driver.switchTo().alert(); 
		       String alertText = alert.getText().trim(); 
		       alert.accept(); 
		       return alertText;
		 } 
	/**
	 * Teardown.
	 * 
	 * @throws Exception the exception
	 */
	
	}

