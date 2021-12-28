package advance_Selenium;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class ReadExcel {

    public static HashMap<String,String> readExcel( String uniqTC) throws IOException {
        FileInputStream file = new FileInputStream("./data.xlsx"); // read fil
        Workbook wb= WorkbookFactory.create(file); // workbook facotry of file
        Sheet sheet = wb.getSheet("Sheet1");// get sheet name

        Iterator<Row> rowIterator = sheet.rowIterator(); // this is to get how many rows are present
        Row rowHeader = rowIterator.next(); // s.no username, paswword, to read first row data
        HashMap<String,String>  dataMap = new HashMap<>(); // create new hash map
        String key;
        String value;
        while (rowIterator.hasNext()){ // am iterating till last row
            Row rowData = rowIterator.next(); // getting each row
            String cellvalue = rowData.getCell(0).toString(); //tc1,tc2
            if(cellvalue.equalsIgnoreCase(uniqTC)){ // TC1== TC1
                int cellcount = rowData.getLastCellNum(); // cellcount of TC1
                for (int i = 0; i < cellcount; i++) { // i will iterate till Last cell of row
                    key = rowHeader.getCell(i).toString(); // from header get each cell (username, password)
                    value=rowData.getCell(i).toString(); // for each data of TC1 get cell value (12345,paswrod1234)
                    dataMap.put(key,value); // put key and value
                }
            }
        }
        return dataMap;
    }



    public static void writeExcel( String uniqTC,String header,String cellVlaue) throws IOException {
        FileInputStream file = new FileInputStream("./data.xlsx"); // read fil
        Workbook wb= WorkbookFactory.create(file); // workbook facotry of file
        Sheet sheet = wb.getSheet("Sheet1");// get sheet name

        Iterator<Row> rowIterator = sheet.rowIterator(); // this is to get how many rows are present
        Row rowHeader = rowIterator.next(); // s.no username, paswword, to read first row data
        while (rowIterator.hasNext()){ // am iterating till last row
            Row rowData = rowIterator.next(); // getting each row
            String cellvalue = rowData.getCell(0).toString(); //tc1,tc2
            if(cellvalue.equalsIgnoreCase(uniqTC)){ // TC1== TC1
                int cellcount = rowData.getLastCellNum(); // cellcount of TC1
                for (int i = 0; i < cellcount; i++) { // i will iterate till Last cell of row
                    String key = rowHeader.getCell(i).toString(); // from header get each cell (username, password)
                    if(key.equalsIgnoreCase(header)) {
                        rowData.createCell(i).setCellValue(cellVlaue); // for each data of TC1 get cell value (12345,paswrod1234)
                        break;
                    }
                }
            }
        }
    }

    //jghjjljhgkjhgiuhjib

    public static void main(String[] args) throws IOException {
        HashMap<String, String> dataMap = readExcel("TC!");
        dataMap.get("USERNAME");
        dataMap.get("PASSWORD");
    }




}
