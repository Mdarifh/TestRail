package MyTest;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import Base.BaseTest;

public class GoogleTest extends BaseTest {

	@Test(priority = 1)
	public void titleTest() {
		TestCaseId = "1";
		String title = driver.getTitle();
		System.out.println("page title: "+ title);
		Assert.assertEquals(title, "Google");
	}
	
	@Test(priority = 2)
	public void isSearchExit() {
		TestCaseId = "2";
		boolean flag = driver.findElement(By.xpath("//textarea[@name='q']")).isDisplayed();
		Assert.assertTrue(flag);
	}
}
