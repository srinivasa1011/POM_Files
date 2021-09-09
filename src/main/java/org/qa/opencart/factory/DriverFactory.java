package org.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	private OptionsManager op;
	public static String highlight;
	public WebDriver initDriver(Properties prop)
	{	
		String browser=prop.getProperty("browser");
		highlight=prop.getProperty("highlight");
		op=new OptionsManager(prop);
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(op.getChromeOptions());
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(op.getFireFoxOptions());
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else
			System.out.println("wrong driver");
		
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public Properties initProperties()
	{
		Properties prop=null;
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return prop;
	}

}
