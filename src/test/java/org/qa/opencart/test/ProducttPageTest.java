package org.qa.opencart.test;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utilities.ExcelUtil;

public class ProducttPageTest extends BaseTest{
	
	@BeforeClass
	public void setup()
	{
		ap=lp.signup(prop.getProperty("username"),prop.getProperty("password"));	
	}
	
	@DataProvider
	public Object[][] getDataSets()
	{
		return ExcelUtil.getDatafromExcel("Sheet1");
	}
	@Test(dataProvider="getDataSets")
	public void verifyProductInfo(String prod,String prodType, String code, String reward,  String availability)
	{
		ps=ap.searchText("mac");
		prodpage=ps.clickProduct(prod);
		Map<String,String>mp=prodpage.getProductListInfo();
		Assert.assertEquals(mp.get("Brand"), prodType);
		Assert.assertEquals(mp.get("Product Code"), code);
		Assert.assertEquals(mp.get("Reward Points"), reward);
		Assert.assertEquals(mp.get("Availability"),availability );	
	}
	
	@Test
	public void verifyPriceInfo()
	{
		ps=ap.searchText("MacBook Air");
		prodpage=ps.clickProduct("MacBook Air");
		List<String> li=prodpage.getPriceInfo();
		Assert.assertEquals(li.get(0), "$1,000.00");
		Assert.assertEquals(li.get(1), "Ex Tax: $1,000.00");	
	}

}
