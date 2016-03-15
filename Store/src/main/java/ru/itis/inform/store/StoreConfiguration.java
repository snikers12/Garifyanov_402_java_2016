package ru.itis.inform.store;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.itis.inform.store.dao")
public class StoreConfiguration {
//    Properties getProperties() {
//        Properties properties = new Properties();
//        try {
//            properties.load(
//                    new FileInputStream("C:\\Users\\\u0410\u0434\u043c\u0438\u043d\\IdeaProjects\\Store\\src\\main\\resources\\store.properties"));
//        } catch (Exception ex) {
//            throw new IllegalArgumentException(ex);
//        }
//        return properties;
//    }

//    @Bean
//    public ItemsDao itemsDaoCsvBasedImpl(){
//        return new ItemsDaoCsvBasedImpl(new File(getProperties().getProperty("csvFilepath")));
//    }

//    @Bean
//    public StoreService storeService(){
//        return new StoreServiceImpl();
//    }
}
