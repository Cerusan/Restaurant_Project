package ru.cerus.restaurantproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RestaurantProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantProjectApplication.class, args);
    }

}
