package com.example.rpsgame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheatingComputerTest {
    @Test
    void whenCheating_whenPlayerChoosesRock_itChoosesPaper() {
        CheatingComputer cheatingComputer = new CheatingComputer();

        String cheatersChoice = cheatingComputer.getComputerChoice("rock");

        assertThat(cheatersChoice).isEqualTo("paper");
    }

    @Test
    void whenCheating_whenPlayerChoosesScissors_itChoosesRock() {
        CheatingComputer cheatingComputer = new CheatingComputer();

        String cheatersChoice = cheatingComputer.getComputerChoice("scissors");

        assertThat(cheatersChoice).isEqualTo("rock");
    }

    @Test
    void whenCheating_whenPlayerChoosesPaper_itChoosesScissors() {
        CheatingComputer cheatingComputer = new CheatingComputer();

        String cheatersChoice = cheatingComputer.getComputerChoice("paper");

        assertThat(cheatersChoice).isEqualTo("scissors");
    }
}
