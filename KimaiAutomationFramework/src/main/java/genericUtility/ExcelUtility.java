package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	FileInputStream fis;
	FileOutputStream fos;
	
	public String readDataFromExcel(String sheetName,int rowNum,int cellnum) throws Exception
	{
	     fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
	     Workbook wb = WorkbookFactory.create(fis);
	     return wb.getSheet(sheetName).getRow(rowNum).getCell(cellnum).toString();
    }
	
	public int getRowCount(String sheetName) throws Exception
	{
		   fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		   Workbook wb=WorkbookFactory.create(fis);
		   return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	
	public int getcellcount(String sheetName) throws Exception
	{
		fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
        return wb.getSheet(sheetName).getLastRowNum(); 
	}
	
	public void writeDataInNewCell(String sheetName,int rowNum,int cellNum,String value) throws Exception
	{
		fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
		fos=new FileOutputStream("./src/test/resources/TestData1.xlsx");
		wb.write(fos);
	}
	
	public String FormattedDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception
	{
		fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		return df.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		
	}
	
}