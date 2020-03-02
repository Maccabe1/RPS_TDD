package com.example.rpsgame;

import java.util.Random;

public class RandomComputer implements Computer {

    private Random random;

    public RandomComputer(Random random) {
        this.random = random;
    }

    public String getComputerChoice(String thePlayersChoice) {

        int choice = random.nextInt(COMPUTERS_CHOICE.length);
        return COMPUTERS_CHOICE[choice];
    }
}
