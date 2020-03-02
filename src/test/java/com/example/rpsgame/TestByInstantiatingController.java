package com.example.rpsgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TestByInstantiatingController {

    @Mock
    RandomComputer randomComputer;

    WebController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new WebController(randomComputer, null);

        when(randomComputer.getComputerChoice(any())).thenReturn("rock");
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
        when(randomComputer.getComputerChoice(any())).thenReturn("scissors");

        Model model = new ExtendedModelMap();

        controller.playGame("computer", "anything", model);

        assertThat(model.getAttribute("computerChoice"), equalTo("scissors"));
    }

    @Test
    void rockBeatsScissors() {
        when(randomComputer.getComputerChoice(any())).thenReturn("scissors");

        Model model = new ExtendedModelMap();

        controller.playGame("computer", "rock", model);

        assertThat(model.getAttribute("outcome"), equalTo("You Win"));
    }

    @Test
    void scissorsLosesToRock() {
        when(randomComputer.getComputerChoice(any())).thenReturn("rock");

        Model model = new ExtendedModelMap();

        controller.playGame("computer", "scissors", model);

        assertThat(model.getAttribute("outcome"), equalTo("Computer Wins"));
    }

    @Test
    void playerChoiceMatchesComputerChoice() {
        when(randomComputer.getComputerChoice(any())).thenReturn("rock");

        Model model = new ExtendedModelMap();

        controller.playGame("computer", "rock", model);

        assertThat(model.getAttribute("outcome"), equalTo("Draw"));
    }
}
