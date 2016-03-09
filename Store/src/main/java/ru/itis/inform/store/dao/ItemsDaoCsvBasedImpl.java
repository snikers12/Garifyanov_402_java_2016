package ru.itis.inform.store.dao;

import com.univocity.parsers.csv.*;
import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.*;

public class ItemsDaoCsvBasedImpl implements ItemsDao{
    static File file = new File("D:/code/new.csv");

    public static List<String[]> parseFile(){
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        CsvParser parser = new CsvParser(settings);
        List<String[]> allRows;
        try {
            allRows = parser.parseAll(new FileReader(file));
        }
        catch (FileNotFoundException e){
            throw new IllegalStateException();
        }
        System.out.println(allRows);
        return allRows;
    }

    public static void writeInFile(List<String[]> allRows){
        List<Object[]> newRows = new ArrayList<Object[]>();
        for (String[] allRow : allRows) {
            newRows.add(allRow);
        }
        try {
            CsvWriter writer = new CsvWriter(new FileWriter(file), new CsvWriterSettings());
            writer.writeRowsAndClose(newRows);
        }
        catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    public void delete(String itemName) {
        List<String[]> stores;
        stores = parseFile();
        for (String[] item : stores){
            if (item[0].equals(itemName)){
                stores.remove(item);
                break;
            }
        }
        writeInFile(stores);
    }

    public Item select(String itemName) {
        List<String[]> stores = null;
        stores = parseFile();
        for (String[] item : stores){
            if (item[0].equals(itemName)) {
                Item newItem = new Item(itemName);
                newItem.setPrice(Double.parseDouble(item[1]));
                return newItem;
            }
        }
        return null;
    }
}
