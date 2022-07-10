package com.example.housing_rental_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@EnableCaching()
public class HousingRentalManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingRentalManagementSystemApplication.class, args);
    }

}
