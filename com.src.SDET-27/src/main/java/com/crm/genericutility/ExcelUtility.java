package com.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Abhis
 *
 */
public class ExcelUtility {

	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */

	public String getDataFromExcel(String sheetName, int rownum, int celNum) throws Throwable {

		FileInputStream fis = new FileInputStream("./data/excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rownum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	/**
	 * 
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {

		FileInputStream fis = new FileInputStream("./data/excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();

	}

	public void setDataExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {

		FileInputStream fis = new FileInputStream("./data/excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(cellNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/excel.xlsx");
		wb.write(fos);
		wb.close();

	}

}
