package com.Selenium.Training_TestCases;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Datadriven_Testdata {

	@Test
	public void TestData() throws IOException {

		FileInputStream file = new FileInputStream(
				"C:\\eclipse-workspace\\com.Selenium.Training\\src\\test\\java\\com\\Selenium\\Training_TestData\\testdata.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet worksheet = workbook.getSheet("sheet1");

		Iterator<Row> rowiterator = worksheet.iterator();

		while (rowiterator.hasNext()) {

			Row rowvalue = rowiterator.next();

			Iterator<Cell> cellIterator = rowvalue.iterator();

			while (cellIterator.hasNext()) {

				Cell cellvalue = cellIterator.next();

				System.out.print(cellvalue + " ");
			}
			System.out.println();
		}

	}

}
