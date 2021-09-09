package org.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utilities.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

@BeforeClass
public void RegosteratopmPageSetUp()
{
	rp=lp.naviageToRegistrationPage();
}
@DataProvider
public Object[][] dataSet2()
{
	return ExcelUtil.getDatafromExcel("Users_List");
}
@Test(dataProvider="dataSet2")
public void FormEntryTest1(String fn, String ln, String eml,String phn, String passwrd) {
	System.out.println("SUBMITTING USER FORM....");		
	Assert.assertTrue(rp.formEntry(fn,ln,eml,phn,passwrd), "msg");
}

}
