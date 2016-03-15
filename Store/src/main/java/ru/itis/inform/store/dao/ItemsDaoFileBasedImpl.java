package ru.itis.inform.store.dao;

import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.models.Item;

import java.util.*;
import java.io.*;

@Component
public class ItemsDaoFileBasedImpl implements ItemsDao{
    File file = new File(getProperties().getProperty("filePath"));

    public ItemsDaoFileBasedImpl() {
    }

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

    ArrayList<Item> readFromFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:/code/new.txt"));
            String line;
            ArrayList<Item> stores = new ArrayList<Item>();
            try {
                while ((line = reader.readLine()) != null) {
                    stores.add(new Item(line));
                }
            }
            catch (IOException e) {
                throw new IllegalStateException();
            }
            return stores;
        }
        catch (FileNotFoundException e) {
            throw new IllegalStateException();
        }
    }

    void writeInFile(ArrayList<Item> list){
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream("D:/code/new.txt"));
            for (Item item : list) {
                out.println(item.getName());
            }
            out.close();
        } catch (FileNotFoundException e) {
            throw new IllegalStateException();
        }

    }

    public void delete(String itemName){
        ArrayList<Item> stores = null;
        stores = readFromFile();
        for (Item item : stores){
            if (item.getName().equals(itemName)) {
                stores.remove(item);
                break;
            }
        }
        writeInFile(stores);
    }

    public Item select(String itemName) {
        ArrayList<Item> stores = null;
        stores = readFromFile();
        for (Item item : stores){
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }
}
