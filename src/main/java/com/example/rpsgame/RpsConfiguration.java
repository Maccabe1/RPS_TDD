package com.example.rpsgame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RpsConfiguration {
    @Bean
    public Computer computer() {
        return new ComputerOpponent(new Random());
    }
}
