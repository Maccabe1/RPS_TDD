package com.example.rpsgame;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


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
}
