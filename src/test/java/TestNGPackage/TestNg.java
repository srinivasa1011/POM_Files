package TestNGPackage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg {
	public WebDriver driver;

	@BeforeTest
	public void f1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get("https://demo.opencart.com/index.php?route=account/register");
		//System.out.println(driver.getCurrentUrl());
		
	} 
	@DataProvider
	public Object[][] dataSet()
	{
		return new Object[][] {
				{"lokesh","rahul","abcd@yy.com","989898989","Pass1200909"},
				{"ravi","ashwin","abeecd@yy.com","955555589","Pass1200909"},
				{"jasprit","bumrah","ab55cd@yy.com","9666989","Pass1200909"},
				{"mohmd","shami","ab5555cd@yy.com","9894898989","Pass1200909"},
				{"rishab","pant","abc44444d@yy.com","977798989","Pass1200909"}
		};
	}

	@Test(dataProvider="dataSet")
	public void FormEntryTest1(String fn, String ln, String eml,String phn, String passwrd) {
		System.out.println("SUBMITTING USER FORM....");		
		Assert.assertTrue(VerifyDataEntry(fn,ln,eml,phn,passwrd), "msg");

	}
	

	public Boolean VerifyDataEntry(String fn, String ln, String eml,String phn, String passwrd)  {
		By fname = By.xpath("//input[@name='firstname']");
		By lname = By.xpath("//input[@name='lastname']");
		By email = By.xpath("//input[@name='email']");
		By telephone = By.xpath("//input[@name='telephone']");
		By password = By.xpath("//input[@name='password']");
		By cfmpassword = By.xpath("//input[@name='confirm']");
		By agree = By.xpath("//input[@type='checkbox']");
		By submit = By.xpath("//*[@type='submit']");
		By verifyText = By.xpath("//div[@id='content']//h1");
		Actions act = new Actions(driver);
		Random r=new Random();
		System.out.println("entering data...");
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		act.sendKeys(driver.findElement(fname), fn).perform();
		act.sendKeys(driver.findElement(lname), ln).perform();
		act.sendKeys(driver.findElement(email), ""+ r.nextInt()+eml).perform();
		act.sendKeys(driver.findElement(telephone), phn).perform();
		act.sendKeys(driver.findElement(password), passwrd).perform();
		act.sendKeys(driver.findElement(cfmpassword),passwrd).perform();
		driver.findElement(agree).click();
		driver.findElement(submit).click();
		if (driver.findElement(verifyText).getText().contains("Created"))
		{
			System.out.println("account created");
			WebElement w=driver.findElement(By.linkText("My Account"));
			act.moveToElement(w).click().perform();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement w2=driver.findElement(By.linkText("Logout"));
			act.moveToElement(w2).click().perform();
		return true;
		}
		else
		{
			driver.quit();
			return false;
		}
	    
	}

	@AfterTest
	public void f10() {
	//	driver.quit();

	}
}
