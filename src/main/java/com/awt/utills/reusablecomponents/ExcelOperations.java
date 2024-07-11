package com.awt.utills.reusablecomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.awt.utills.exceptions.EmptyFileException;
/**
 * This Class Specially Designed For Doing Excel Operations
 * @author Ankit Yadav
 */

public class ExcelOperations {
	private static String dataProviderPath = "DataProviderPath";

	/**
	 * this method is specially designed for data provider annotation
	 *
	 * @param methodName
	 * @param className
	 */
	public static LinkedHashMap<String, String> getReadExcelFile(String sheetName, String fileName) {

		XSSFWorkbook workbook = null;
		LinkedHashMap<String, String> map = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					PropertiesOperations.getPropertyValueByKey(dataProviderPath) + "\\" + fileName + ".xlsx");
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum();
			int totalColumn = sheet.getRow(0).getLastCellNum();
			int columnNumber = getColumnNumber("Data", sheetName,
					PropertiesOperations.getPropertyValueByKey(dataProviderPath) + "\\" + fileName + ".xlsx");
			map = new LinkedHashMap<>();
			for (int i = 1; i <= totalRow; i++) {
				String key = sheet.getRow(0).getCell(columnNumber).getStringCellValue();
				String value = sheet.getRow(i).getCell(columnNumber).getStringCellValue();
				map.put(key, value);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new EmptyFileException("...File...IS...Not...Found");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				// Handle exception during close, if needed
			}

		}
		return map;
	}

	/**
	 * this method is used for find out the passed column header number
	 *
	 * @param columnName-> which column name number you want to know
	 * @param filepath     -> address of excel file
	 * @param sheetNme->   name of the sheet in which sheet your data is present
	 * @return
	 */
	public static int getColumnNumber(String columnName, String sheetName, String filePath) {
		int columnNumber = 0;
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			int total_Column = sheet.getRow(0).getLastCellNum();
			int totalRow = sheet.getLastRowNum();

			for (int i = 0; i < total_Column; i++) {
				String value = sheet.getRow(0).getCell(i).getStringCellValue();
				if (columnName.trim().equals(value.trim())) {
					columnNumber = i;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Unable To Find Column Name :" + columnName + " Due To This Exception :" + e.getMessage());
		} finally {
			try {
				fis.close();
				workbook.close();
			} catch (Exception e) {
			}

		}
		return columnNumber;

	}

	/***
	 * By this method we can fetch the data according to test case number and given
	 * column name if test case number is not present so it will take by default
	 * value;
	 *
	 * @param fileName->   excel file name
	 * @param columnName-> column header name
	 * @param testCase->   test case id
	 * @return data -> which present inside the cell according to pass test case and
	 *         column Name
	 */

	public synchronized static String getCellData(String fileName, String columnName, String testCase) {

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		String data = null;
		String path = "./TestDataRev/" + fileName + ".xlsx";
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int totalRow = sheet.getLastRowNum();
			int totalCoulmn = sheet.getRow(0).getLastCellNum();
			int rowNumber = getRowNumber(testCase, path);
			int columnNumber = getColumnNum(columnName, path);
			DataFormatter format = new DataFormatter();
			data = format.formatCellValue(sheet.getRow(rowNumber).getCell(columnNumber));
		} catch (IOException e) {
			System.out.println("Unable To Find The FileName :" + fileName + " Due To This Exception :"
					+ e.getMessage().toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unable To Read Excel File Due To This Exception " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;

	}

	/**
	 *
	 * @param columnName -> which column name index number you want to know
	 * @param path->     file path of your file
	 * @return int -> coulmn Number
	 */
	public static int getColumnNum(String columnName, String path) {
		int columnNumber = 0;

		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			int total_Column = sheet.getRow(0).getLastCellNum();
			int totalRow = sheet.getLastRowNum();
			for (int i = 0; i < total_Column; i++) {
				String value = sheet.getRow(0).getCell(i).getStringCellValue();
				if (value.trim().equalsIgnoreCase(columnName)) {
					columnNumber = i;
					break;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Unable To Find Column Name :" + columnName + " Due To This Exception :" + e.getMessage());
			e.printStackTrace();
		} finally {
		}
		return columnNumber;

	}

	/**
	 * By this method we can find out the Row Number to pass a test case id if test
	 * case id is not present then it will automatically return "default " row
	 * number
	 *
	 * @param testCase-> test Case Number
	 * @param path->     path of the file
	 * @return row number
	 */
	public static int getRowNumber(String testCase, String path) {
		int rowNumber = 0;
		int defaultRowNum = 0;
		boolean flag = false;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		if (testCase.isBlank()) {
			testCase = "default";
		}
		try {
			FileInputStream fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			int totalRow = sheet.getLastRowNum();
			String cellValue = null;
			for (int i = 1; i <= totalRow; i++) {
				try {
					DataFormatter format = new DataFormatter();
					cellValue = format.formatCellValue(sheet.getRow(i).getCell(0));
					if (cellValue.trim().equalsIgnoreCase(testCase)) {
						rowNumber = i;
						flag = true;
						break;
					} else if (cellValue.trim().equalsIgnoreCase("default")) {
						defaultRowNum = i;
					}
				} catch (Exception e) {

				}
			}
		} catch (Exception e) {
			System.out.println("Unable To Find The File :" + e.getMessage() + "Due To This Exception");
			e.printStackTrace();
		} finally {

		}
		if (!flag) {
			rowNumber = defaultRowNum;
		}
		return rowNumber;
	}

	/**
	 * By this method we can fetch a multiple records by giving records number for
	 * same given TestCaseId
	 *
	 * @param FileName->    which file have a data
	 * @param testCaseId--> test case id
	 * @param record-->     how many records you want
	 */
	public static String[][] getRecords(String fileName, String testCaseId, int... record) {

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		String path = "./TestDataRev/" + fileName + ".xlsx";
		String[][] table = null;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int totalRow = sheet.getLastRowNum();
			int totalColumn = sheet.getRow(0).getLastCellNum();
			int testCaseColumnIndexNumber = getColumnNum("TestCase", path);
			ArrayList<Integer> dupTestIdIndexNum = new ArrayList<>(
					getRowIndexOfDuplicateTestId(testCaseId, sheet, totalRow, testCaseColumnIndexNumber));
			// String testCaseId = "290";
			int records = 0;
			try {
				if (record[0] >= 0) {
					records = record[0];
					if (records <= dupTestIdIndexNum.size() && (records != 0)) {
						table = getRecords(records, dupTestIdIndexNum, sheet, totalColumn);
					} else {
						System.out.println(" In The Table We Found  Only : " + dupTestIdIndexNum.size()
								+ " Similar Records For Same TestCase Id  But You Want : " + records + " Records");
					}
				}
			} catch (Exception e) {
				System.out.println(" In The Table We Found  Only : " + dupTestIdIndexNum.size()
						+ " Similar Records For Same TestCase Id  But You Want : " + records + " Records");
			}

		} catch (Exception e) {
			System.out.println("Unable To Find The File :" + e.getMessage() + "Due To This Exception");
			e.printStackTrace();
		}
		return table;
	}

	/**
	 * By This method We Can Get Records Of The Table which has a same test case id
	 *
	 * @param records->            how many records you want
	 * @param dupTestIdIndexNum--> Duplicate Test Case id Row Index Number
	 * @param sheet-->             Sheet
	 * @param totalColumn-->       How Many Columns We have
	 * @return
	 */
	public static String[][] getRecords(int records, ArrayList<Integer> dupTestIdIndexNum, XSSFSheet sheet,
			int totalColumn) {
		DataFormatter format = new DataFormatter();
		String[][] table;
		boolean flag = true;
		table = new String[records + 1][totalColumn];
		for (int i = 0; i < records; i++) {
			if (i == 1) {
				flag = false;
			}
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				if (flag) {
					table[i][j] = format.formatCellValue(sheet.getRow(0).getCell(j));
				}
				table[i + 1][j] = format.formatCellValue(sheet.getRow(dupTestIdIndexNum.get(i)).getCell(j));
			}
		}
		return table;

	}

	/**
	 * By this method we can get all duplicated TestCaseId Row IndexNumber
	 *
	 * @param testCaseId                -> we need to pass test case id
	 * @param sheet                     -> sheet Name
	 * @param totalRow                  -> In Excel File How Many Rows Are Present
	 * @param testCaseColumnIndexNumber
	 * @return
	 */
	public static LinkedList<Integer> getRowIndexOfDuplicateTestId(String testCaseId, XSSFSheet sheet, int totalRow,
			int testCaseColumnIndexNumber) {
		DataFormatter format = new DataFormatter();
		LinkedList<Integer> dupTestIdIndexNum = new LinkedList<>();
		String value;
		for (int i = 1; i <= totalRow; i++) {
			try {
				value = format.formatCellValue(sheet.getRow(i).getCell(testCaseColumnIndexNumber));
				if (testCaseId.trim().equals(value.trim())) {
					dupTestIdIndexNum.add(i);
				}
			} catch (Exception e) {

			}
		}
		return dupTestIdIndexNum;
	}

	/**
	 * this method for fetching all the records present inside the sheet
	 *
	 * @param fileName
	 * @param testCaseId
	 * @param record
	 * @return String[][]
	 */
	public static String[][] getAllRecords(String fileName, String sheetName) {

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		String path = "./TestDataRev/" + fileName + ".xlsx";
		String[][] table = null;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum();
			int totalColumn = sheet.getRow(0).getLastCellNum();
			DataFormatter format = new DataFormatter();
			table = new String[totalRow][totalColumn];
			for (int i = 1; i <= totalRow; i++) {
				for (int j = 0; j < totalColumn; j++) {
					try {
						table[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Unable To Find The File :" + e.getMessage() + "Due To This Exception");
			e.printStackTrace();
		}
		return table;
	}

}
