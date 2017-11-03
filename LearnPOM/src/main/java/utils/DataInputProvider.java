package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInputProvider {
	public Object[][] readExcel(String excelName) throws InvalidFormatException, IOException
	{	
	File exfile=new File("./data/"+excelName+".xlsx");                 
	XSSFWorkbook workBook=new XSSFWorkbook(exfile);
	XSSFSheet sheetname=workBook.getSheetAt(0);
	int rowcount=sheetname.getLastRowNum();
	int colcount=sheetname.getRow(1).getLastCellNum();
	Object[][] data=new Object[rowcount][colcount];	
	for (int i = 1; i <=rowcount; i++) {
		XSSFRow row = sheetname.getRow(i);
		for (int j = 0; j < colcount; j++) {
			XSSFCell cell = row.getCell(j);
			String value = cell.getStringCellValue();
			data[i-1][j]=value;
			
		}
	}
	return data;		
	}

	
		
}
