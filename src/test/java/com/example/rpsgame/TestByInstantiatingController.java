package com.example.rpsgame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class TestByInstantiatingController {

    @Mock
    Computer computer;
    Cheater cheater;

    WebController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new WebController(computer, cheater);
        when(computer.getComputerChoice()).thenReturn("rock");
    }

    @Test
    void itRendersTheResultsPage() {
        String viewToRender = controller.playGame("computer", "blah", new ExtendedModelMap());

        assertThat(viewToRender, equalTo("results"));
    }

    @Test
    void itPassesTheUsersChoiceToTheModel() {
        Model model = new ExtendedModelMap();

        controller.playGame("computer", "scissors", model);

        assertThat(model.getAttribute("personChoice"), equalTo("scissors"));
    }

    @Test
    void itPassesTheComputerChoiceToTheModel() {
        when(computer.getComputerChoice()).thenReturn("scissors");

        Model model = new ExtendedModelMap();

        controller.playGame("computer", "anything", model);

        assertThat(model.getAttribute("computerChoice"), equalTo("scissors"));
    }

    @Test
    void rockBeatsScissors() {
        when(computer.getComputerChoice()).thenReturn("scissors");

        Model model = new ExtendedModelMap();

        controller.playGame("computer", "rock", model);

        assertThat(model.getAttribute("outcome"), equalTo("You Win"));
    }

    @Test
    void scissorsLosesToRock() {
        when(computer.getComputerChoice()).thenReturn("rock");

        Model model = new ExtendedModelMap();

        controller.playGame("computer", "scissors", model);

        assertThat(model.getAttribute("outcome"), equalTo("Computer Wins"));
    }

    @Test
    void playerChoiceMatchesComputerChoice() {
        when(computer.getComputerChoice()).thenReturn("rock");

        Model model = new ExtendedModelMap();

        controller.playGame("computer", "rock", model);

        assertThat(model.getAttribute("outcome"), equalTo("Draw"));
    }
}
