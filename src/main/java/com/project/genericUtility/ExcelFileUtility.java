package com.project.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public final class ExcelFileUtility {
	
	private FileInputStream fis;
	private Workbook workbook;
	private FileOutputStream fos;
	
	/**
	 * this method is used to load the excel file
	 * @param filePath
	 */
	public void loadExcelData(String filePath) {
		try {
			fis= new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to get the data from the excel
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getExcelData(String sheet,int rowNum,int cellNum) {

		return new DataFormatter().formatCellValue(workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum));

	}

	/**
	 * this method is used write the data in excel file
	 * @param fileInputPath
	 * @param Sheet
	 * @param rowCount
	 * @param cellcount
	 * @param data
	 */
	public void setExcelData(String Sheet,int rowCount,int cellcount,String data) {


		workbook.getSheet(Sheet).getRow(rowCount).createCell(cellcount).setCellValue(data);


	}
	/**
	 * this method is used to save and close the data in excel file
	 * @param fileSavePath
	 */
	public void saveExcelFile(String fileSavePath) {

		try {
			fos = new FileOutputStream(fileSavePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to close the workbook
	 */
	public void closeWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
