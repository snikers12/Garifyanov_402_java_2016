package ru.itis.inform.store.services;

import org.apache.log4j.Logger;

import ru.itis.inform.store.dao.ItemsDao;

public class StoreServiceImpl implements StoreService {

    ItemsDao itemsDao;
    private static final Logger log = Logger.getLogger(StoreServiceImpl.class);

    public StoreServiceImpl(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public void buy(String itemName) {
        itemsDao.delete(itemName);
        log.info(itemName + " was bought.");
    }

    public boolean isExist(String itemName) {
        log.info(itemName + " was selected.");
        return itemsDao.select(itemName) != null;
    }
//
//    public static void main(String[] args) {
//        StoreServiceImpl storeService = new StoreServiceImpl();
//    }
}

