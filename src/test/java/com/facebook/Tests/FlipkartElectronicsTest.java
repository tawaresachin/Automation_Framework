package com.facebook.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.facebook.Pages.FlipkartElectronicsPage;
import com.facebook.base.BaseClass;
import com.facebook.utilities.UtilityClass;

public class FlipkartElectronicsTest extends BaseClass
{
	protected static WebDriver driver;
	UtilityClass utility;
	FlipkartElectronicsPage electronics;
	Boolean result;
	String TCID;
	String str;
	
	@BeforeClass
	public void elctronicsTestSetup() throws InterruptedException
	{
		driver = FlipkartHomeTest.handOver();
		utility=new UtilityClass();
		electronics=new FlipkartElectronicsPage(driver);
	}
	
	@Test
	public void checkNSetPriceBarTest() throws InterruptedException
	{
		TCID="TC022";
		result=electronics.checkNSetPriceBar(driver);
		org.testng.Assert.assertTrue(result);
	}
	
	@Test (dependsOnMethods="checkNSetPriceBarTest")
	public void DesiredProcessorTest() throws InterruptedException
	{
		TCID="TC023";
		result=electronics.selectDesiredProcessor();
		Assert.assertTrue(result);
	}
	
	@Test (dependsOnMethods="DesiredProcessorTest")
	public void extractPriceOfFirstLaptopTest()
	{
		TCID="TC024";
		result=electronics.extractPriceOfFirstLaptop();
		Assert.assertTrue(result);
	}
	
	@AfterMethod()
	public void listenLoginPage(ITestResult result) throws IOException
	{
		if (ITestResult.FAILURE==result.getStatus())
		{
			utility.Screenshot(driver, TCID);
			str="Test Case "+TCID+" is failed";
			utility.logging(str);
		}
		else
			if(ITestResult.SUCCESS==result.getStatus())
			{
				str="Test Case "+TCID+" is Passed";
				Reporter.log(str,true);
			}
			else
				if(ITestResult.SKIP==result.getStatus())
				{
					String str="Test Case "+TCID+" is Skipped";
					Reporter.log(str,true);
				}
	}
	
	@AfterClass
	public void quitBrowser()
	{
		driver.quit();
		driver=null;
	}
	
	
}
