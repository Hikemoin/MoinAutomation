package com.qa.Ecommerce.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public static Object[][] getTestDataFromExcel(String sheetName) {
		String projectPath = System.getProperty("user.dir");
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(projectPath + "\\Config File\\EcommerceTestData.xlsx");
		} catch (IOException e) {

			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] excelData = new Object[rows][cols];
		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				org.apache.poi.ss.usermodel.CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					excelData[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					excelData[i][j] = cell.getNumericCellValue();
					break;
				case BOOLEAN:
					excelData[i][j] = cell.getBooleanCellValue();
					break;

				default:
					System.out.println("Invalid Data Type");
					break;
				}

			}
		}

		return excelData;

	}
}
