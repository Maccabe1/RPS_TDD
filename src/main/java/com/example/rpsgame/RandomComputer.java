package com.example.rpsgame;

import java.util.Random;

public class RandomComputer implements Computer {
    private Random random;
    private static final String[] COMPUTERS_CHOICE = new String[]{"rock", "paper", "scissors"};

    public RandomComputer(Random random) {
        this.random = random;
    }

    public String getComputerChoice() {
        int choice = random.nextInt(COMPUTERS_CHOICE.length);
        return COMPUTERS_CHOICE[choice];
    }
}
