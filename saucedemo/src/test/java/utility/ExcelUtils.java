package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Object[][] getCellData(String filepath, String sheetname) throws IOException{
		FileInputStream f=new FileInputStream(filepath);
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet sh=wb.getSheet(sheetname);
		int row=sh.getLastRowNum();// row starting from 0,1,2,,,,
		System.out.println("number of rows =" + row);
		int cell=sh.getRow(0).getLastCellNum();
		System.out.println("number of coloumns =" + cell);
		Object[][] data=new Object[row][cell];
		DataFormatter formatter=new DataFormatter();
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<cell;j++) {
				
				data[i-1][j]=formatter.formatCellValue(sh.getRow(i).getCell(j));
			}
		}
		
		wb.close();
		f.close();
		
		return data;
		
	}

}
