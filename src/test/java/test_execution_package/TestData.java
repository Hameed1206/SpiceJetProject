package test_execution_package;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import base_package.BaseClass;

public class TestData extends BaseClass {

	public static Object[][] SignInWithEmail() throws IOException {
		
		Object[][] data = new Object[readValueFromExcel("SignInE").getPhysicalNumberOfRows()-1][readValueFromExcel("SignInE").getRow(0).getPhysicalNumberOfCells()];
		for (int i = 1; i < readValueFromExcel("SignInE").getPhysicalNumberOfRows(); i++) {	
			XSSFRow row = readValueFromExcel("SignInE").getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.toString();
			} }

		return data;
}
	public static Object[][] SignInWithPhoneNo() throws IOException {
		
		Object[][] data = new Object[readValueFromExcel("SignIn").getPhysicalNumberOfRows()-1][readValueFromExcel("SignIn").getRow(0).getPhysicalNumberOfCells()];
		for (int i = 1; i < readValueFromExcel("SignIn").getPhysicalNumberOfRows(); i++) {	
			XSSFRow row = readValueFromExcel("SignIn").getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				XSSFCell cell = row.getCell(j);
				if (cell.getCellType() == CellType.NUMERIC) {
	                data[i-1][j] = String.valueOf((long) cell.getNumericCellValue()); 
	            } else {
				data[i-1][j] = cell.toString();
	            }	} }

		return data;
}
    public static Object[][] signUpTestDatas() throws IOException {
		
		Object[][] data = new Object[readValueFromExcel("SignUp").getPhysicalNumberOfRows()-1][readValueFromExcel("SignUp").getRow(0).getPhysicalNumberOfCells()];
		for (int i = 1; i < readValueFromExcel("SignUp").getPhysicalNumberOfRows(); i++) {	
			XSSFRow row = readValueFromExcel("SignUp").getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				XSSFCell cell = row.getCell(j);
				if (cell.getCellType() == CellType.NUMERIC) {
	                data[i-1][j] = String.valueOf((long) cell.getNumericCellValue());
	            } else {
				data[i-1][j] = cell.toString();
	            }	} }

		return data;
}
    public static Object[][] bookingDetails() throws IOException {
		
		Object[][] data = new Object[readValueFromExcel("Details").getPhysicalNumberOfRows()-1][readValueFromExcel("Details").getRow(0).getPhysicalNumberOfCells()];
		for (int i = 1; i < readValueFromExcel("Details").getPhysicalNumberOfRows(); i++) {	
			XSSFRow row = readValueFromExcel("Details").getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				XSSFCell cell = row.getCell(j);
				if (cell.getCellType() == CellType.NUMERIC) {
	                data[i-1][j] = String.valueOf((long) cell.getNumericCellValue());
	            } else {
				data[i-1][j] = cell.toString();
	            }	} 	}

		return data;
}
}
