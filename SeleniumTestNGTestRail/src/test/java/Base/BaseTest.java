package Base;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.testrailmanager.TestRailManager;



public class BaseTest {

	
	protected WebDriver driver;
	
	protected String TestCaseId;
	
	
	
	
	@Parameters({"url", "browser"})
	@BeforeTest
	public void setup(String url, String browserName) {
		System.out.println("launch browser: " +browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("Please pass the right browserName...." + browserName);
		}
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@AfterMethod
	public void addResultsToTestRail(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			TestRailManager.addResultForTestCase("testCaseId",TestRailManager.TEST_CASE_PASS_STATUS, "");
		}else if(result.getStatus()==ITestResult.FAILURE) {
			TestRailManager.addResultForTestCase(TestCaseId, TestRailManager.TEST_CASE_FAIL_STATUS,"test got failed... "
		+ result.getName() + " : FAILED");
		}
	}
}
