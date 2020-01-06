package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo_A {

	public static void main(String[] args) throws IOException {
		
		String filepath = System.getProperty("user.dir")+"/Data/Test_Data.xlsx";
		 File fl = new File(filepath);
		 
		 FileInputStream fis = new FileInputStream(fl);
		 
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 
		 XSSFSheet sh = wb.getSheetAt(0);
		 
		 String name = sh.getRow(0).getCell(0).getStringCellValue();
		 
		 System.out.println(name);
				 

	}

}
