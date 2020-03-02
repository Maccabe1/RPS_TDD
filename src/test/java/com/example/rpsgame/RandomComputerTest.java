package com.example.rpsgame;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomComputerTest {
    @Test
    void itCanReturnScissors() {
        Computer randomComputer = new ComputerOpponent(new Random(3));

        String choice = randomComputer.getComputerChoice();

        assertThat(choice).isEqualTo("scissors");
    }

    @Test
    void itCanReturnPaper() {
        Computer randomComputer = new ComputerOpponent(new Random(2));

        String choice = randomComputer.getComputerChoice();

        assertThat(choice).isEqualTo("paper");
    }

    @Test
    void itCanReturnRock() {
        Computer randomComputer = new ComputerOpponent(new Random(1));

        String choice = randomComputer.getComputerChoice();

        assertThat(choice).isEqualTo("rock");
    }

    @Test
    void whenCheating_whenPlayerChoosesRock_itChoosesPaper() {
        Cheater cheater = new ComputerOpponent(null);

        String cheatersChoice = cheater.getChoiceViaCheating("rock");

        assertThat(cheatersChoice).isEqualTo("paper");
    }

    @Test
    void whenCheating_whenPlayerChoosesScissors_itChoosesRock() {
        Cheater cheater = new ComputerOpponent(null);

        String cheatersChoice = cheater.getChoiceViaCheating("scissors");

        assertThat(cheatersChoice).isEqualTo("rock");
    }

    @Test
    void whenCheating_whenPlayerChoosesPaper_itChoosesScissors() {
        Cheater cheater = new ComputerOpponent(null);

        String cheatersChoice = cheater.getChoiceViaCheating("paper");

        assertThat(cheatersChoice).isEqualTo("scissors");
    }
}
