package ru.itis.inform.store;

import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.services.StoreService;

import java.io.*;
import java.util.*;

public class StoreServiceFactory {

    private static StoreServiceFactory instance;
    private Properties properties;
    private StoreService storeService;
    private ItemsDao itemsDao;

    private StoreServiceFactory() {
        properties = new Properties();

        try {
            properties.load(
                    new FileInputStream("C:\\Users\\\u0410\u0434\u043c\u0438\u043d\\IdeaProjects\\Store\\src\\main\\resources"));

            String storeServiceClass = properties.getProperty("storeService.class");
            String itemsDaoClass = properties.getProperty("itemsDao.class");

            this.storeService = (StoreService)Class.forName(storeServiceClass).newInstance();
            this.itemsDao = (ItemsDao)Class.forName(itemsDaoClass).newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    static {
        instance = new StoreServiceFactory();
    }

    public static StoreServiceFactory getInstance() {
        return instance;
    }

    public StoreService getStoreService() {
        return storeService;
    }

    public ItemsDao getItemsDao() {
        return itemsDao;
    }
}