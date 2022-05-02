package com.Selenium.Training_TestCases;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFileRead {

	@Test
	public void ReadData() throws IOException {



		FileInputStream fs = new FileInputStream("C:\\eclipse-workspace\\com.Selenium.Training\\src\\test\\java\\com\\Selenium\\Training_TestData\\testdata.xlsx");


		XSSFWorkbook wb = new XSSFWorkbook(fs);

		XSSFSheet ws=wb.getSheetAt(0);

		int rowsize=ws.getLastRowNum();

		int colsize=	ws.getRow(0).getLastCellNum();
		
		System.out.println("ROW SIZE IS "+ rowsize);
		System.out.println("COLUMN SIZE" +colsize);
		
		String cv=ws.getRow(2).getCell(1).getStringCellValue();
		
		System.out.println("my data :  " +cv);
		for(int i=1 ;i<=rowsize;i++) {
			for(int j=0;j<colsize;j++) {
				
			
			String cellvalue=ws.getRow(i).getCell(j).getStringCellValue();
			System.out.print(cellvalue+" ");
			
			}
			System.out.println();
		}
		
		
		wb.close();

	}

}
