package com.common.backend.utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.api.utils.ConfigurationManager;

public class ExcelUtils {
public String filePath;
	public String sheetName;
	
    public ExcelUtils(String filePath,String sheetName) {
		this.filePath=filePath;
		this.sheetName=sheetName;
	}
    
  public Object getCellData(int rowNum,int cellNum) {
    	Object outPut = null;
    	try {
			FileInputStream fis=new FileInputStream(filePath);
			HSSFWorkbook workbook=new HSSFWorkbook(fis);
			HSSFSheet sheet=workbook.getSheet(sheetName);
			HSSFRow row=sheet.getRow(rowNum);
			HSSFCell cell=row.getCell(cellNum);
			
			if (cell.getCellType().toString().contains("STRING")) {
				outPut = cell.getStringCellValue();
			} else if (cell.getCellType().toString().contains("NUMERIC")) {
				outPut = cell.getNumericCellValue();
			}
			System.out.println(outPut);
    	} catch (Exception e) {
			System.out.println("Exception Occured. Error:"+e.getMessage());
		}
		return outPut;
    }
  
   public int getRowCount() {
    	int number = 0;
    	try {
			FileInputStream fis=new FileInputStream(filePath);
			HSSFWorkbook workbook=new HSSFWorkbook(fis);
			HSSFSheet sheet=workbook.getSheet(sheetName);
			number=sheet.getPhysicalNumberOfRows();
			System.out.println("RowCount:"+number);
    	} catch (Exception e) {
			System.out.println("Exception Occured. Error:"+e.getMessage());
		}
		return number;
    }
  
    
    public static void main(String[] args) {
    	ExcelUtils data=new ExcelUtils(System.getProperty("user.dir")+"\\resources\\"+ConfigurationManager.getBundle().getProperty("data.provider").toString(), "userDetails");
    	data.getCellData(1,0);
	}
    
}
