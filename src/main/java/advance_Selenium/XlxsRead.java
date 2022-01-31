package advance_Selenium;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class XlxsRead {

    public static  HashMap<String, String> readExecel(String TC) throws IOException {
        FileInputStream file = new FileInputStream("./data.xlxs");
        Workbook wb = WorkbookFactory.create(file);
        Sheet sheet = wb.getSheet("Sheet1");

        Iterator<Row> rowIterator = sheet.iterator();
        Row rowHeader = rowIterator.next();
        HashMap<String, String> dataMap = new HashMap<>();
        String key;
        String value;
        while (rowIterator.hasNext()) {
            Row rowData = rowIterator.next();
            String cellval = rowData.getCell(0).toString();
            if (cellval.equalsIgnoreCase(TC)) {
                int cellCount = rowData.getLastCellNum();
                for (int i = 0; i < cellCount; i++) {
                    key = rowHeader.getCell(i).toString();
                    value=rowData.getCell(i).toString();
                    dataMap.put(key,value);

                }


            }
        }
       return dataMap;
    }


    public static  void writeExecel(String TC, String header, String val) throws IOException {
        FileInputStream file = new FileInputStream("./data.xlxs");
        Workbook wb = WorkbookFactory.create(file);
        Sheet sheet = wb.getSheet("Sheet1");

        Iterator<Row> rowIterator = sheet.iterator();
        Row rowHeader = rowIterator.next();
        HashMap<String, String> dataMap = new HashMap<>();
        String key;
        String value;
        while (rowIterator.hasNext()) {
            Row rowData = rowIterator.next();
            String cellval = rowData.getCell(0).toString();
            if (cellval.equalsIgnoreCase(TC)) {
                int cellCount = rowData.getLastCellNum();
                for (int i = 0; i < cellCount; i++) {
                    key = rowHeader.getCell(i).toString();
               if(key.equalsIgnoreCase(header)) {
                   rowData.createCell(i).setCellValue(val);
               }



                }


            }
        }

    }

    public static void main(String[] args) throws IOException {
        HashMap<String,String> dataMap = readExecel("TC1");
        dataMap.get("USERNAME");
        dataMap.get("PASSWORD");
    }
}
