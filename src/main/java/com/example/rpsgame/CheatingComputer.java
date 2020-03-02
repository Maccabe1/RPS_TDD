package com.example.rpsgame;

import java.util.Arrays;

public class CheatingComputer implements Computer {
    @Override
    public String getComputerChoice(String thePlayersChoice) {
        int readPlayersChoice = Arrays.asList(COMPUTERS_CHOICE).indexOf(thePlayersChoice);

        int computerChoosesBestOption = (readPlayersChoice + 1) % COMPUTERS_CHOICE.length;

        return COMPUTERS_CHOICE[computerChoosesBestOption];
    }
}
