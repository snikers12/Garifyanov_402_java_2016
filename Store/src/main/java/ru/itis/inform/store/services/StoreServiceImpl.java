package ru.itis.inform.store.services;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.*;
import ru.itis.inform.store.dao.ItemsDao;

public class StoreServiceImpl implements StoreService {

    @Autowired
    @Qualifier("itemsDaoCsvBasedImpl")
    ItemsDao itemsDao;
    private static final Logger log = Logger.getLogger(StoreServiceImpl.class);

    public StoreServiceImpl() {
    }

    public void setItemsDao(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

//    public StoreServiceImpl(ItemsDao itemsDao) {
//        this.itemsDao = itemsDao;
//    }

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

