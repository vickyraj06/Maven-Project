package com.Selenium.Training_TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class DataDriven {

	public static void main(String[] args) throws IOException {




		FileInputStream excel = new FileInputStream("C:\\eclipse-workspace\\com.Selenium.Training\\src\\test\\java\\com\\Selenium\\Training_TestData\\testdata.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(excel);

		XSSFSheet ws=wb.getSheet("sheet1");

		Iterator<Row> rowiterator=ws.iterator();
		
		while(rowiterator.hasNext()) {
			
			Row  rowvalue=rowiterator.next();
			
			Iterator<Cell> cellIterator=rowvalue.iterator();
			
			while(cellIterator.hasNext()) {
				
				Cell cellvalue=cellIterator.next();
				
				System.out.print(cellvalue+" ");
			}
			System.out.println();
		}


	}





}


