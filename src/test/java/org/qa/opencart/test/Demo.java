package org.qa.opencart.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.opencart.utilities.JavaScriptUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	
	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr=new ChromeOptions();
		//cr.addArguments("--incognito");
		//cr.addArguments("--headless");
		WebDriver driver=new ChromeDriver(cr);
		JavaScriptUtil js=new JavaScriptUtil(driver);
		driver.get("https://www.healthifyme.com/blog/8-reasons-eat-amla-every-day/");
		System.out.println("refreshing page______");
		js.refresh();
		System.out.println(js.getTitle());
		//System.out.println(js.getInnerTextvalue());
		//js.scrollDown();
	    //Thread.sleep(2000);
		//js.scrollUp();
		WebElement ele=driver.findElement(By.xpath("//button[@type='submit']"));
		//js.doClick(ele);
		//js.scrollToElementLoc(ele);
		js.borderElement(ele);
		//Thread.sleep(2000);
		js.flash(ele);
		js.doClick(ele);
		//for(int i=0;i<3;i++)
		//js.generateAlert("hi");
		js.scrollHeight("900");
	};

}
