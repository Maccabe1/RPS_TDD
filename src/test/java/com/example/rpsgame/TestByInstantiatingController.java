package com.example.rpsgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class TestByInstantiatingController {
    @Mock
    Computer computer;

    WebController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new WebController(computer);
        when(computer.getComputerChoice()).thenReturn("rock");
    }

    @Test
    void itRendersTheResultsPage() {
        String viewToRender = controller.playGame("blah", new ExtendedModelMap());

        assertThat(viewToRender, equalTo("results"));
    }

    @Test
    void itPassesTheUsersChoiceToTheModel() {
        Model model = new ExtendedModelMap();

        controller.playGame("scissors", model);

        assertThat(model.getAttribute("personChoice"), equalTo("scissors"));
    }

    @Test
    void itPassesTheComputerChoiceToTheModel() {
        when(computer.getComputerChoice()).thenReturn("scissors");

        Model model = new ExtendedModelMap();

        controller.playGame("anything", model);

        assertThat(model.getAttribute("computerChoice"), equalTo("scissors"));
    }

    @Test
    void rockBeatsScissors() {
        when(computer.getComputerChoice()).thenReturn("scissors");

        Model model = new ExtendedModelMap();

        controller.playGame("rock", model);

        assertThat(model.getAttribute("outcome"), equalTo("You Win"));
    }

    @Test
    void scissorsLosesToRock() {
        when(computer.getComputerChoice()).thenReturn("rock");

        Model model = new ExtendedModelMap();

        controller.playGame("scissors", model);

        assertThat(model.getAttribute("outcome"), equalTo("Computer Wins"));
    }


    @Test
    void playerChoiceMatchesComputerChoice() {
        when(computer.getComputerChoice()).thenReturn("rock");

        Model model = new ExtendedModelMap();

        controller.playGame("rock", model);

        assertThat(model.getAttribute("outcome"), equalTo("Draw"));
    }
}
