package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import GlobalMethods.LoginMethods;

import com.thoughtworks.selenium.*;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class PracticeTests_Driver {

	private static WebDriver driver;
	private static String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	LoginMethods _login = new LoginMethods();
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.ironspeed.com/OMS/SalesRep/Show-SalesRep-Gallery.aspx";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void _01LaunchSampleApp() throws Exception {
		try {
		Assert.assertTrue(_login.SimpleLogin(driver, baseUrl));
		} catch (Error e) {
		verificationErrors.append(e.toString());
		}
	}

	@Test
	public void _02ClickOrdersButton () throws Exception {
		driver.findElement(By.linkText("ORDERS")).click();
	    try {
	        assertEquals("Orders", driver.getTitle());

	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }


	}

	@Test
	public void _03GetTableData() throws Exception {
	    //driver.findElement(By.className("gb_A gb_8 gb_f")).click();
	    //driver.findElement(By.id("gb_71")).click();
		WebElement webTable = driver.findElement(By.id("ProductsTableControlGrid"));
		//List<WebElement> TotalRowCount = webTable.findElements(By.xpath("//table[@id='ProductsTableControlGrid']/tbody/tr"));

        List<WebElement> TotalRowCount = webTable.findElements(By.cssSelector("table#ProductsTableControlGrid /tr"));
		
		System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
		
		// Now we will Iterate the Table and print the Values   
		int RowIndex=1;
		for(WebElement rowElement:TotalRowCount)
		{
		      List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td"));
		      int ColumnIndex=1;
		      for(WebElement colElement:TotalColumnCount)
		      {
		           System.out.println("Row "+RowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
		           ColumnIndex=ColumnIndex+1;
		       }
		      RowIndex=RowIndex+1;
		 }
		
	    //int rowCount = driver.findElements(By.xpath("//table[@id='ProductsTableControlGrid']/tbody/tr[*]/td[2]")).size();
	    //int columnCount = driver.findElements(By.xpath("//table[@id='ProductsTableControlGrid']/tbody/tr/td[*]")).size();
	    
	    //System.out.println("Row count: " + rowCount);
	    //System.out.println("Column count: " + columnCount);

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
