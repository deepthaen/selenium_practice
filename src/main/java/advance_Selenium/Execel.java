package advance_Selenium;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Execel {

    public static HashMap<String, String>  readexecel(String TC) throws IOException {
        FileInputStream file = new FileInputStream("./data.xlxs");
        Workbook wb = WorkbookFactory.create(file);
        Sheet sheet = wb.getSheet("sheet1");

        Iterator<Row> rowIterator = sheet.iterator();
        Row rowHeader = rowIterator.next();
        HashMap<String, String> datamap = new HashMap<>();
        String key;
        String value;

        while(rowIterator.hasNext()){
            Row rowData = rowIterator.next();
            String cellValue = rowData.getCell(0).toString();
            if (cellValue.equalsIgnoreCase(TC)){
                int cellCount = rowData.getLastCellNum();
                for (int i = 0; i < cellCount; i++) {
                    key = rowHeader.getCell(i).toString();
                    value = rowData.getCell(i).toString();
                    datamap.put(key,value);

                }

            }

        }

      return datamap;
    }


    public static void  writeexecel(String TC, String header, String values) throws IOException {
        FileInputStream file = new FileInputStream("./data.xlxs");
        Workbook wb = WorkbookFactory.create(file);
        Sheet sheet = wb.getSheet("sheet1");

        Iterator<Row> rowIterator = sheet.iterator();
        Row rowHeader = rowIterator.next();
        HashMap<String, String> datamap = new HashMap<>();
        String key;
        String value;

        while(rowIterator.hasNext()){
            Row rowData = rowIterator.next();
            String cellValue = rowData.getCell(0).toString();
            if (cellValue.equalsIgnoreCase(TC)){
                int cellCount = rowData.getLastCellNum();
                for (int i = 0; i < cellCount; i++) {
                    key = rowHeader.getCell(i).toString();
                    if(key.equalsIgnoreCase(header)) {
                        rowData.createCell(i).setCellValue(values);
                        break;
                    }
                }

            }

        }

    }
}
