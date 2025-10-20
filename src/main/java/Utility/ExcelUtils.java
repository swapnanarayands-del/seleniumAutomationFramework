package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFWorkbook Workbook;
	private static Sheet sheet;
	
//	LOAD EXCEL FILE
	
	public static void loadExcel(String filepath, String sheetName) throws IOException {
		FileInputStream file=new FileInputStream(filepath);
		Workbook=new XSSFWorkbook(file);
		sheet = Workbook.getSheet(sheetName);
	}
//	Get Cell data as String
	
public static String getcellData(int row, int col) {
	Cell cell=sheet.getRow(row).getCell(col);
	if(cell.getCellType()==CellType.STRING) {
return cell.getStringCellValue();
	
	}else if(cell.getCellType()==CellType.NUMERIC) {
		return String.valueOf((int)cell.getNumericCellValue());
	}
	return"";
}

//Get Total Rows
public static int getRowCount() {
	return sheet.getPhysicalNumberOfRows();
	
}

//Close Work book

public static void closeExcel() throws IOException {
	Workbook.close();
}


}
