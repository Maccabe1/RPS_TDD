package com.example.rpsgame;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomComputerTest {
    @Test
    void itCanReturnScissors() {
        Computer randomComputer = new RandomComputer(new Random(3));

        String choice = randomComputer.getComputerChoice();

        assertThat(choice).isEqualTo("scissors");
    }

    @Test
    void itCanReturnPaper() {
        Computer randomComputer = new RandomComputer(new Random(2));

        String choice = randomComputer.getComputerChoice();

        assertThat(choice).isEqualTo("paper");
    }

    @Test
    void itCanReturnRock() {
        Computer randomComputer = new RandomComputer(new Random(1));

        String choice = randomComputer.getComputerChoice();

        assertThat(choice).isEqualTo("rock");
    }
}
