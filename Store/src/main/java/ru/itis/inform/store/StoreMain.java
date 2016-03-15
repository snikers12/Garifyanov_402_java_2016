package ru.itis.inform.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.store.services.StoreService;

public class StoreMain {
    @Autowired
    static StoreService storeService;

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
//
//        StoreService storeService = (StoreService)context.getBean("storeService");

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.itis.inform.store");
        StoreService storeService = (StoreService)context.getBean("storeServiceImpl");
        storeService.isExist("3");
        storeService.buy("3");
    }

}