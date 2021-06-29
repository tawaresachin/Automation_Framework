package com.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
	public static Properties prop;
	static WebDriver driver;
	
	public Properties callProperty() throws IOException
	{
		FileInputStream propFile=new FileInputStream("D:\\Study\\Testing Class\\local\\Automation_Framework\\src\\main\\java\\com\\facebook\\Reporters\\config.properties");
		prop=new Properties();
		prop.load(propFile);
		return prop;
	}
	
	public void initialization() throws IOException
	{
		if(prop.getProperty("browser").equals("Chrome"))
		{
			System.setProperty(prop.getProperty("chromeProperty"),prop.getProperty("chromePath"));
		}
		else 
			if(prop.getProperty("browser").equals("FireFox"))
			{
				System.setProperty(prop.getProperty("gekoProperty"),prop.getProperty("gekoPath"));
			}
			else 
				if(prop.getProperty("browser").equals("Edge"))
				{
					System.setProperty(prop.getProperty("edgeProperty"),prop.getProperty("edgePath"));
				}
			
	}
	
	public WebDriver BrowserFactory()
	{
		if(prop.getProperty("browser").equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else 
			if(prop.getProperty("browser").equals("FireFox"))
			{
				driver=new FirefoxDriver();
			}
			else 
				if(prop.getProperty("browser").equals("Edge"))
				{
					driver=new EdgeDriver();
				}
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		return driver;
	}
	
	public void Waits() throws InterruptedException
	{
		Thread.sleep(3000);
	}

}
