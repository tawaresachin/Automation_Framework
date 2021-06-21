package com.facebook.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.facebook.base.BaseClass;

public class FlipkartLoginPage extends BaseClass
{
	boolean flag;
	
	@FindBy(xpath="//span[@class='_36KMOx']//span") private WebElement loginHeader;
	@FindBy(partialLinkText="Forgot?") private WebElement forgotLink;
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3NgS1a']") private WebElement requestOTP;
	@FindBy(partialLinkText="Create an account") private WebElement createAccount;
	@FindBy(xpath="//div[@class='_1Ijv5h']") private WebElement termsPolicies;
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']") private WebElement userID;
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']") private WebElement password;
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']") private WebElement loginButton;
	
	public FlipkartLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String extractFacebookLoginHeader()
	{
		String header=loginHeader.getText();
		return header;
	}
	
	public boolean checkLoginPageForgotLink()
	{
		flag=forgotLink.isEnabled();
		return flag;
	}
	
	public boolean checkRequestOTPLink()
	{
		flag=requestOTP.isEnabled();
		return flag;
	}
	
	public boolean checkCreateAccountLink()
	{
		flag=createAccount.isEnabled();
		return flag;
	}
	public String checkTermsPoliciesLink()
	{
		String terms=termsPolicies.getText();
		return terms;
		
	}
	
	public boolean enterUserOnLoginPage(String user)
	{
		flag=userID.isEnabled();
		userID.sendKeys(user);
		return flag;
		
	}
	public boolean enterPasswordOnLoginPage(String pass)
	{
		flag=password.isEnabled();
		password.sendKeys(pass);
		return flag;
	}
	public boolean clickOnLoginButton()
	{
		flag=loginButton.isEnabled();
		loginButton.click();
		return flag;
	}

}
