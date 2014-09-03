package com;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestBase;

public class SearchTest extends SeleneseTestBase{

	private static Log log = LogFactory.getLog(SearchTest.class);

	/** The driver. */
	public static WebDriver driver;

	/** The element. */
	public WebElement element;

	/** The wait. */
	public static WebDriverWait wait;

	
	/**
	 * Logincase.
	 * 
	 * @throws Exception the exception
	 */
	@Test
	public void searchcase() throws Exception {
		try
		{
			
		// Login
		SearchTest.driver.switchTo().defaultContent();
		//Assert.assertEquals("Pop Window Title is:", "Oxseed Desktop", SearchTest.driver.getTitle());
		SearchTest.log.info("Switching success");
		SearchTest.wait = new WebDriverWait(SearchTest.driver, 600);
		SearchTest.driver.switchTo().defaultContent();
		//SearchTest.wait.until(visibilityOfElementLocated(By.id("loginviewport__Logindhtmlx_w_dhtmlx_f")));
		WebElement frame = SearchTest.driver.findElement(By.id("loginviewport__Logindhtmlx_w_dhtmlx_f"));
		Assert.assertNotNull(frame);
		SearchTest.driver.switchTo().frame(frame);
		SearchTest.log.info("Switching success");
		SearchTest.driver.findElement(By.id("logon_text"));
		WebElement username, pwd;
		username = checkIdLoaded("UserId");
		pwd = checkIdLoaded("Passwort");
		if (username != null && pwd != null) {
			
			
			LoginTest.driver.findElement(By.id("UserId")).sendKeys("testauto");
				LoginTest.driver.findElement(By.id("Passwort")).sendKeys("mht");
			}
		
		Assert.assertNotNull(SearchTest.driver.findElement(By.id("logon_text")));
        Thread.sleep(8000);        
		SearchTest.driver.findElement(By.id("logon_text")).click();
		SearchTest.log.info("Login Success");
		Assert.assertNotNull(SearchTest.driver.switchTo().defaultContent());


		// Start page Elements

		// welcome note
		WebElement welcomenote, menuview, workbasketview, savedsearch;
		welcomenote = checkApplicationLoaded("span[paneltitle=\"welcome\"] iframe.seedcontent");
		Assert.assertNotNull(welcomenote);
		SearchTest.log.info("welcome note panel element present");

		// menu view
		menuview = checkApplicationLoaded("span[paneltitle=\"menuview\"] iframe.seedcontent");
		Assert.assertNotNull(menuview);
		SearchTest.log.info("Applications panel element present");

		// work basket view
		workbasketview = checkApplicationLoaded("span[paneltitle=\"workbasketmenuview\"] iframe.seedcontent");
		Assert.assertNotNull(workbasketview);
		SearchTest.log.info("Workbaskets panel element present");

		// saved searches

		savedsearch = checkApplicationLoaded("span[paneltitle=\"savedsearchs\"] iframe.seedcontent");
		Assert.assertNotNull(savedsearch);
		SearchTest.log.info("Saved SearchTestes panel element present");

		//Opening SearchTest Application
		final WebElement frame1 = SearchTest.driver.findElement(By.cssSelector("span[paneltitle=\"menuview\"] iframe.seedcontent"));
		SearchTest.driver.switchTo().frame(frame1);
		SearchTest.log.info("Applications panel selected");
		final WebElement content = checkApplicationLoaded("div.objbox");
		Assert.assertNotNull(content);
		WebElement suchegrid;
		suchegrid = checkElementWithGivenText("SearchTest");
		Assert.assertNotNull(suchegrid);
		suchegrid.click();
		SearchTest.log.info("Suche grid clicked");
        SearchTest.driver.switchTo().defaultContent();
        
        //check Elements in the search application
        
        WebElement suche_screen,fulltext,indexes,dt,btn1,btn2,btn3,grid;
        suche_screen=wait.until(visibilityOfElementLocated(By.cssSelector("span[paneltitle=\"simplesearchlayout\"] iframe.seedcontent")));
        Assert.assertNotNull(suche_screen);
        driver.switchTo().frame(suche_screen);
        SearchTest.log.info("SearchTest Screen Selected");
        SearchTest.driver.switchTo().defaultContent();
        
        //full text search
        fulltext=wait.until(visibilityOfElementLocated(By.id("indexkey_search")));
        Assert.assertNotNull(fulltext);
        SearchTest.log.info("Full text SearchTest Text Box Present");
        
        //document type index
        dt=wait.until(visibilityOfElementLocated(By.id("dSel_cont")));
        Assert.assertNotNull(dt);
        SearchTest.log.info("Document type index present");
        
        //Indexes
        indexes=wait.until(visibilityOfElementLocated(By.id("gridCont")));
        Assert.assertNotNull(indexes);
        SearchTest.log.info("Indexes Present");
        
        //buttons
        btn1=checkIdLoaded("SearchTest_text");
        Assert.assertNotNull(btn1);
        SearchTest.log.info("search button present");
        
        btn2=checkIdLoaded("Resetsearch_text");
        Assert.assertNotNull(btn2);
        SearchTest.log.info("Reset button present");
        
        btn3=checkIdLoaded("Save_text");
        Assert.assertNotNull(btn3);
        SearchTest.log.info("Save button present");
        
        //performing search
        
        checkApplicationLoaded("table.obj * td:contains(Name)");
        grid=checkApplicationLoaded("table.obj * td:contains(Name)+td");
        Assert.assertNotNull(grid);
        grid.sendKeys("Ani*");
        btn1.click();
        
        driver.switchTo().defaultContent();
        wait.until(visibilityOfElementLocated(By.id("searchHitList")));
        SearchTest.log.info("Hitlist displayed");
        wait.until(visibilityOfElementLocated(By.id("showpage-1")));
        SearchTest.log.info("pagenumber displayed");
		}
		
        catch(Exception e)
        {
        	SearchTest.log.info(e);
        }}
        
        

		
		

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
		element = SearchTest.wait.until(visibilityOfElementLocated(By.cssSelector(cssSelectorInfo)));
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
		element = SearchTest.driver.findElement(By.cssSelector(applicationPanelInfo));
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
		element = SearchTest.wait.until(visibilityOfElementLocated(By.id(idInfo)));
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
		element = SearchTest.driver.findElement(By.id(applicationIdInfo));
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
		element = SearchTest.wait.until(visibilityOfElementLocated(By.xpath(xpathInfo)));
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
		element = SearchTest.driver.findElement(By.xpath(applicationxpathInfo));
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
		final WebElement table = SearchTest.driver.findElement(By.tagName("table"));
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

	/**
	 * Teardown.
	 * 
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void teardownClass() throws Exception {
		SearchTest.driver.quit();
	}
}

