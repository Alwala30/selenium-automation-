package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writedataexcel {

	public void datawrite(int r,String Data, String Data1, String Data2) throws Exception {
		FileOutputStream File = new FileOutputStream(System.getProperty("user.dir" + "\\TestData\\myfile.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Dealers kawasaki");
		XSSFRow row = sheet.createRow(r);
		row.createCell(0).setCellValue(Data);
		row.createCell(1).setCellValue(Data1);
		row.createCell(2).setCellValue(Data2);

		workbook.write(File);
		workbook.close();
		File.close();
		System.out.println("File is created....");

	}

}
