package com.facebook.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.facebook.Pages.FlipkartHomePage;
import com.facebook.utilities.UtilityClass;

public class FlipkartHomeTest
{
	protected static WebDriver driver;
	UtilityClass utility;
	static FlipkartHomePage homePage;
	Boolean result;
	String TCID;
	String str;
	
	@BeforeClass
	public void InitializeHome() throws IOException, InterruptedException
	{
		driver= FlipkartLoginTest.switchToHomePage();
		utility=new UtilityClass();
		homePage=new FlipkartHomePage(driver);
	}
	
	@BeforeMethod
	public void systemWait() throws InterruptedException
	{
		Thread.sleep(2000);
	}
	
	@Test
	public void FlipkartHomePageLogoTest()
	{
		TCID="TC009";
		result=homePage.checkFlipkartHomePageLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartShoppingCartTest()
	{
		TCID="TC010";
		result=homePage.checkFlipkartShoppingCart();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartOffersTest()
	{
		TCID="TC011";
		result=homePage.checkFlipkartOffers();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartGroceryTest()
	{
		TCID="TC012";
		result=homePage.checkFlipkartGrocery();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartMobilesTest()
	{
		TCID="TC013";
		result=homePage.checkFlipkartMobiles();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartFashionTest()
	{
		TCID="TC014";
		result=homePage.checkFlipkartFashion();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartElectronicsTest()
	{
		TCID="TC015";
		result=homePage.checkFlipkartElectronics();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartHomeOptionTest()
	{
		TCID="TC016";
		result=homePage.checkFlipkartHome();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartAppliancesTest()
	{
		TCID="TC017";
		result=homePage.checkFlipkartAppliances();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartTravelTest()
	{
		TCID="TC018";
		result=homePage.checkFlipkartTravel();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartOthersTest()
	{
		TCID="TC019";
		result=homePage.checkFlipkartOthers();
		Assert.assertTrue(result);
	}
	
	@Test
	public void FlipkartAboutUsLinkTest()
	{
		TCID="TC020"; 
		result=homePage.checkFlipkartAboutUs(driver);
		Assert.assertTrue(result);
	}
	
	@Test
	public void LaptopsNDesktopTest()
	{
		TCID="TC021"; 
		result=homePage.checkLaptopsNDesktop(driver);
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
	public void switchToElectronicsPage() throws InterruptedException
	{
		homePage.navigateToLaptopsNDesktop(driver);
		
	}
	
	@AfterTest
	public static WebDriver handOver()
	{
		return driver;
	}
}
