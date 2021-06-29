package com.facebook.Tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.facebook.Pages.FlipkartLoginPage;
import com.facebook.base.BaseClass;
import com.facebook.utilities.UtilityClass;

public class FlipkartLoginTest extends BaseClass
{
	protected static WebDriver driver ;
	Properties prop;
	UtilityClass utility;
	FlipkartLoginPage loginPage;
	boolean result;
	String TCID;
	String str;
	
	@BeforeClass
	public void setupSystem() throws IOException, InterruptedException
	{
		prop=callProperty();
		initialization();
		driver = BrowserFactory();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		utility=new UtilityClass();
		loginPage=new FlipkartLoginPage(driver);
	}
	
	@BeforeMethod
	public void waits() throws InterruptedException
	{
		Thread.sleep(2000);
	}
	
	@Test
	public void validateLoginHeader()
	{
		TCID="TC001";
		String str=loginPage.extractFacebookLoginHeader();
		result=str.equals("Login");
		Assert.assertEquals("Login", str);
	}
	
	@Test
	public void validateForgotLink()
	{
		TCID="TC002";
		result=loginPage.checkLoginPageForgotLink();
		Assert.assertTrue(result);
	}
	@Test
	public void validateRequestOTPLink()
	{
		TCID="TC003";
		result=loginPage.checkRequestOTPLink();
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateCreateAccountLink()
	{
		TCID="TC004";
		result=loginPage.checkCreateAccountLink();
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateTermsPoliciesLink()
	{
		TCID="TC005";
		String terms=loginPage.checkTermsPoliciesLink();
		result=terms.equals("By continuing, you agree to Flipkart's Terms of Use and Privacy Policy.");
		Assert.assertTrue(result);
//		Assert.fail();
	}
	
	@Test
	public void validateUserFieldonLoginPage() throws EncryptedDocumentException, IOException
	{
		TCID="TC006";
		result=loginPage.enterUserOnLoginPage(utility.readWorkbook("Sheet1", 1, 1));
		Assert.assertTrue(result);
	}
	
	@Test (dependsOnMethods= {"validateUserFieldonLoginPage"})
	public void validatePasswordFieldonLoginPage() throws EncryptedDocumentException, IOException
	{
		TCID="TC007";
		result=loginPage.enterPasswordOnLoginPage(utility.readWorkbook("Sheet1", 1, 2));
		Assert.assertTrue(result);
	}
	
	@Test(dependsOnMethods= {"validatePasswordFieldonLoginPage"})
	public void validateLoginButtonClickAction()
	{
		TCID="TC008";
		result=loginPage.clickOnLoginButton();
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
	public static WebDriver switchToHomePage()
	{
		return driver;
	}
}
