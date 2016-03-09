package ru.itis.inform.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.store.services.StoreService;

public class StoreMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        StoreService storeService = (StoreService)context.getBean("storeService");

        storeService.isExist("2");
        storeService.buy("2");
    }

}