package ru.itis.inform.store.dao;

import com.univocity.parsers.csv.*;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.*;

@Component
public class ItemsDaoCsvBasedImpl implements ItemsDao{
    static File file = new File(getProperties().getProperty("csvFilePath"));

    static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("C:\\Users\\\u0410\u0434\u043c\u0438\u043d\\IdeaProjects\\Store\\src\\main\\resources\\store.properties"));
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return properties;
    }

    public ItemsDaoCsvBasedImpl() {
    }

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
