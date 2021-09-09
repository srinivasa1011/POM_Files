package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ElementUtil;

public class ProductPage {
	private WebDriver driver;
	private ElementUtil ele;
	private By prodlist=By.xpath("(//div[@id='content']//ul)[3]//li");
	private By prodname=By.xpath("//div[@id='content']//h1");
	private By price=By.xpath("(//div[@id='content']//ul)[4]//li");
	ProductPage(WebDriver driver)
	{
		this.driver=driver;
		ele=new ElementUtil(driver);
	}
	
	public Map<String,String> getProductListInfo()
	{
		Map<String,String>mp=new HashMap<String,String>();
		String s;
		String[] v;
		List<WebElement>li=ele.getElements(prodlist);
		for(WebElement e: li)
		{
			s=e.getText();
			System.out.println(s);
			v=s.split(":");
			mp.put(v[0].trim(), v[1].trim());
		}
		return mp;
	}
	
	public List<String> getPriceInfo()
	{
		List<WebElement>li= ele.getElements(price);
		List<String>list=new ArrayList<String>();
		int k=0;
		for(WebElement e: li)
		{
			list.add(k,e.getText());
			k++;
		}
		return list;
	}
}
