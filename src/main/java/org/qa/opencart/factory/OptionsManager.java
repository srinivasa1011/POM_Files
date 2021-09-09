package org.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	Properties prop;
	
	OptionsManager(Properties prop)
	{
		this.prop=prop;
	}
	
	public   ChromeOptions getChromeOptions()
	{
		
		ChromeOptions cp= new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
			cp.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			cp.addArguments("--incognito");
		return cp;		
	}
	public    FirefoxOptions getFireFoxOptions()
	{
		
		FirefoxOptions fp= new FirefoxOptions();
		if(Boolean.parseBoolean(DriverFactory.headless))
			fp.addArguments("--headless");
		if(Boolean.parseBoolean(DriverFactory.incognito))
			fp.addArguments("--incognito");
		return fp;		
	}

}
