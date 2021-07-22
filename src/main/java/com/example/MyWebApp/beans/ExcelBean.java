package com.example.MyWebApp.beans;

import com.example.MyWebApp.data.DataRow;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Named
@ViewScoped
public class ExcelBean implements Serializable {
    private final static long serialVersionUID = 1L;

    private final static String FILE_NAME = "/home/n81ur3/fruits.xlsx";
    private List<String> fruits = new LinkedList<>();
    private List<Double> quantities = new LinkedList<>();
    private List<DataRow> dataRows = new LinkedList<>();

    public void loadData() {
        try {
            FileInputStream in = new FileInputStream(FILE_NAME);

            Workbook workbook = new XSSFWorkbook(in);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.rowIterator();
            iterator.next();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();

                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.println(currentCell.getStringCellValue() + "--");
                        fruits.add(currentCell.getStringCellValue());
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.println(currentCell.getNumericCellValue() + "--");
                        quantities.add(currentCell.getNumericCellValue());
                    }
                }
                System.out.println("---------------------------");
            }

            for (int i = 0; i < fruits.size(); i++) {
                dataRows.add(new DataRow(fruits.get(i), quantities.get(i)));
            }

            System.out.println("---------------------------");
        } catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
    }

    public List<DataRow> getDataRows() {
        return dataRows;
    }

    public void setDataRows(List<DataRow> dataRows) {
        this.dataRows = dataRows;
    }
}
