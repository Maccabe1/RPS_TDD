package com.example.rpsgame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RpsConfiguration {
    @Bean
    public RandomComputer randomComputer() {
        return new RandomComputer(new Random());
    }

    @Bean
    public CheatingComputer cheatingComputer() {
        return new CheatingComputer();
    }

}
