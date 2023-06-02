package MyTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;


public class OpenCartTest extends BaseTest {
	
	@Test(priority = 1)
	public void logotest() {
		TestCaseId = "3";
		System.out.println("Open Cart - logo test");
		boolean flag = driver.findElement(By.cssSelector("img[title='naveenopencart']")).isDisplayed();
		Assert.assertEquals(flag,true);
	}
	
	@Test(priority = 2)
	public void forgetPwdLinkExitTest() {
		TestCaseId = "4";
		System.out.println("open cart - forget pwd test");
		Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password")).isDisplayed());
	}
	
}
