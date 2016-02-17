package ru.itis.inform.store.dao;

import ru.itis.inform.store.dao.models.Item;

import java.util.*;
import java.io.*;

public class ItemsDaoFileBasedImpl implements ItemsDao{
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
