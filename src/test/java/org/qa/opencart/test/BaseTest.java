package org.qa.opencart.test;

import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.opencart.factory.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.ProductSearch;
import com.qa.opencart.pages.RegistrationPage;

public class BaseTest {
    WebDriver driver;
	DriverFactory df;
	LoginPage lp;
	Properties prop;
	AccountsPage ap;
	ProductSearch ps;
	ProductPage prodpage;
	RegistrationPage rp;
	
	@BeforeTest
	public void setUp()
	{
		df=new DriverFactory();
		prop=df.initProperties();
		driver=df.initDriver(prop);
		lp=new LoginPage(driver);
	}
	
	@AfterTest
	public void closeBrowser()
	{
	 //driver.quit();
	}
}
