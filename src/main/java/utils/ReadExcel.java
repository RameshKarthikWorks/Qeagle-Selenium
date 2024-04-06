package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	
	public static String[][] readExcel(String filename) throws IOException
	{
		XSSFWorkbook book = new XSSFWorkbook("./Data/"+filename+".xlsx");
		
		XSSFSheet sheet = book.getSheetAt(0);
		
		int row = sheet.getLastRowNum();
		
		System.out.println("Number of Rows ="+row);
		
		int col = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Number of Col ="+col);
		
		String [][] data = new String[row][col];
		
		for(int i=1;i<=row;i++)
		{
			XSSFRow rowvalue = sheet.getRow(i);
			
			for(int j=0;j<col;j++)
			{
				String stringCellValue = rowvalue.getCell(j).getStringCellValue();
				
				data[i-1][j]= stringCellValue;
				
			}
		}
		
		book.close();
		return data;
				
	}

}
