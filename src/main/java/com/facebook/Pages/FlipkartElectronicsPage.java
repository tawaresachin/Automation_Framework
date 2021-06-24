package com.facebook.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.facebook.base.BaseClass;
import com.facebook.utilities.UtilityClass;

public class FlipkartElectronicsPage extends BaseClass
{
	Actions act;
	Boolean flag;
	 UtilityClass utility;
	
	@FindBy(xpath="(//div[@class='_2IN3-t _1mRwrD'])") private WebElement pricebar;
	@FindBy(xpath="//div[@class='_24_Dny']") private WebElement processor;
	@FindBy(xpath="(//div[@class='_4rR01T'])[1]") private WebElement firstEntity;
	@FindBy(xpath="(//div[@class='_25b18c']//child::div)[1]") private WebElement price;
	
	public FlipkartElectronicsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean checkNSetPriceBar(WebDriver driver) throws InterruptedException
	{
		flag=pricebar.isEnabled();
		utility=new UtilityClass();
		act=utility.action(driver);
		Waits();
		act.moveToElement(pricebar).clickAndHold().moveByOffset(125, 0).release().build().perform();
		Waits();
		return flag;
	}
	
	public Boolean selectDesiredProcessor() throws InterruptedException
	{
		flag=processor.isEnabled();
		processor.click();
		Waits();
		return flag;
	}
	
	public Boolean extractPriceOfFirstLaptop()
	{
		flag=firstEntity.isEnabled();
		String str="Price of first Laptop is: "+price.getText();
		Reporter.log(str,true);
		return flag;
	}
}
