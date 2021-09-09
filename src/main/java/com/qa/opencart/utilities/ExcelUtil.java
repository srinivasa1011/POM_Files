package com.qa.opencart.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static String Data_Sheet_Path = "./src/test/resources/testdata/UserData.xlsx";
	private static Workbook wb;
	private static Sheet sh;

	public static Object[][] getDatafromExcel(String sheetname)
	{
		FileInputStream fis;
		Object[][] ob=null;
		try {
			fis = new FileInputStream(Data_Sheet_Path);
			wb=WorkbookFactory.create(fis);
			sh=wb.getSheet(sheetname);
			ob=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
			for(int i=0;i<sh.getLastRowNum();i++)
				for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
				{
					ob[i][j]=sh.getRow(i+1).getCell(j).toString();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ob;
	}
}
