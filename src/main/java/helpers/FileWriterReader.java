package helpers;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;


public class FileWriterReader {
    private static Logger log = Logger.getLogger(FileWriterReader.class.getName());
    private static final String NAME_OF_FILE = "target/generated-sources/usersData.xlsx";

    public void writeDataIntoFile(String sheetName, List<String> listToWrite) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < listToWrite.size(); i++) {
            Row row = sheet.createRow(i);
            Cell idCell = row.createCell(0);
            idCell.setCellValue(i + 1);

            Cell nameCell = row.createCell(1);
            nameCell.setCellValue(listToWrite.get(i));
        }
        FileOutputStream out = new FileOutputStream(new File(NAME_OF_FILE));
        workbook.write(out);
        out.close();
    }

    public String readPropertyById(int id, String sheetName) {
        String property = "";
        try {

            Workbook myExcelBook = WorkbookFactory.create(new FileInputStream(NAME_OF_FILE));
            Sheet myExcelSheet = myExcelBook.getSheet(sheetName);
            Row row = myExcelSheet.getRow(id);

            if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                property = row.getCell(1).getStringCellValue();
                if (property.isEmpty()) property = "EMPTY";
            }
            myExcelBook.close();

        } catch (IOException | InvalidFormatException e) {
            log.severe(String.format("Something went wrong: %s", e.getMessage()));
        }
        return property;
    }

    public int getCountOfRows(String sheetName) throws IOException, InvalidFormatException {
        Workbook myExcelBook = WorkbookFactory.create(new FileInputStream(NAME_OF_FILE));
        Sheet myExcelSheet = myExcelBook.getSheet(sheetName);
        return myExcelSheet.getLastRowNum();
    }
}
