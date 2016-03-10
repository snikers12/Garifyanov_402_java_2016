package ru.itis.inform.store.dao;

import com.univocity.parsers.tsv.*;
import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.*;

public class ItemsDaoTsvBasedImpl implements ItemsDao{
    static File file;

    public ItemsDaoTsvBasedImpl(File tsvFilePath) {
        file = tsvFilePath;
    }

    public static List<String[]> parseFile(){
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        TsvParser parser = new TsvParser(settings);
        List<String[]> allRows;
        try {
            allRows = parser.parseAll(new FileReader(file));
        }
        catch (FileNotFoundException e){
            throw new IllegalStateException();
        }
        return allRows;
    }

    public static void writeInFile(List<String[]> allRows){
        List<Object[]> newRows = new ArrayList<Object[]>();
        for (String[] allRow : allRows) {
            newRows.add(allRow);
        }
        try {
            TsvWriter writer = new TsvWriter(new FileWriter(file), new TsvWriterSettings());
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
