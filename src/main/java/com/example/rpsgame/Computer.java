package com.example.rpsgame;

public interface Computer {
    String[] COMPUTERS_CHOICE = new String[] {"rock", "paper", "scissors"};

    String getComputerChoice(String thePlayersChoice);
}