package com.facebook.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.BaseClass;
import com.facebook.utilities.UtilityClass;

public class FlipkartHomePage extends BaseClass
{
	
	Boolean flag;
	UtilityClass utility=new UtilityClass();
	Actions act;
	
	@FindBy(xpath="//a//img[@class='_2xm1JU']") private WebElement logo;
	@FindBy(xpath="//a[@class='_3SkBxJ']") private WebElement cart;
	@FindBy(xpath="//div[text()='Top Offers']") private WebElement offers;
	@FindBy(xpath="//div[text()='Grocery']") private WebElement grocery;
	@FindBy(xpath="//div[text()='Mobiles']") private WebElement mobiles;
	@FindBy(xpath="//div[text()='Fashion']") private WebElement fashion;
	@FindBy(xpath="//div[text()='Electronics']") private WebElement electronics;
	@FindBy(xpath="//div[text()='Home']") private WebElement home;
	@FindBy(xpath="//div[text()='Appliances']") private WebElement appliances;
	@FindBy(xpath="//div[text()='Travel']") private WebElement travel;
	@FindBy(xpath="//div[contains(text(),'Beauty, Toys & More')]") private WebElement others;
	@FindBy(xpath="//div[@class='_2Brcj4']//a[contains(text(),'About Us')]") private WebElement aboutUs;
	@FindBy(linkText="Laptop and Desktop") private WebElement laptopsNdesktops;
	
	public FlipkartHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public Boolean checkFlipkartHomePageLogo()
	{
		flag=logo.isDisplayed();
		return flag;
	}
	
	public Boolean checkFlipkartShoppingCart()
	{
		flag=cart.isEnabled();
		return flag;
		
	}
	public Boolean checkFlipkartOffers()
	{
		flag=offers.isEnabled();
		return flag;
	}
	
	public Boolean checkFlipkartGrocery()
	{
		flag=grocery.isEnabled();
		return flag;
	}
	public Boolean checkFlipkartMobiles()
	{
		flag=mobiles.isEnabled();
		return flag;
		
	}
	public Boolean checkFlipkartFashion()
	{
		flag=fashion.isEnabled();
		return flag;
	}
	public Boolean checkFlipkartElectronics()
	{
		flag=electronics.isEnabled();
		return flag;
	}
	
	public Boolean checkLaptopsNDesktop(WebDriver driver)
	{
		act=utility.action(driver);
		act.moveToElement(electronics).perform();
		flag=laptopsNdesktops.isEnabled();
		return flag;
		
	}
	
	public void navigateToLaptopsNDesktop(WebDriver driver) throws InterruptedException
	{
		act=utility.action(driver);
		act.moveToElement(electronics).build().perform();
		Waits();
		act.moveToElement(laptopsNdesktops).click().build().perform();		
	}
	
	public Boolean checkFlipkartHome()
	{
		flag=home.isEnabled();
		return flag;
	}
	public Boolean checkFlipkartAppliances()
	{
		flag=appliances.isEnabled();
		return flag;
	}
	
	public Boolean checkFlipkartTravel()
	{
		flag=travel.isEnabled();
		return flag;
	}
	
	public Boolean checkFlipkartOthers()
	{
		flag=others.isEnabled();
		return flag;
	}

	public Boolean checkFlipkartAboutUs(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].scrollIntoView(true)", aboutUs);
		flag=aboutUs.isEnabled();
		return flag;
	}
}
