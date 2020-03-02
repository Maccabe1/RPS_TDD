package com.example.rpsgame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private Computer computer;
    private Cheater cheater;

    public WebController(
            Computer computer,
            Cheater cheater
    ) {
        this.computer = computer;
        this.cheater = cheater;
    }

    @PostMapping("/playagame")
    public String playGame(
            @RequestParam(name = "opponent", required = false) String theOpponentType,
            @RequestParam(name = "choice", required = false) String thePlayersChoice,
            Model model) {

        if (thePlayersChoice == null) {
            return "index";
        }

        String computerChoice = null;

        switch (theOpponentType) {
            case "computer":
                computerChoice = computer.getComputerChoice();
                break;

            case "cheater":
                computerChoice = cheater.getChoiceViaCheating(thePlayersChoice);
                break;
        }

        model.addAttribute("opponentType", theOpponentType);
        model.addAttribute("personChoice", thePlayersChoice);
        model.addAttribute("computerChoice", computerChoice);
        model.addAttribute("outcome", playRPS(thePlayersChoice, computerChoice));

        return "results";
    }

    private String playRPS(String thePlayersChoice, String computerChoice) {
        if (
                thePlayersChoice.equals("rock") && computerChoice.equals("scissors") ||
                        thePlayersChoice.equals("paper") && computerChoice.equals("rock") ||
                        thePlayersChoice.equals("scissors") && computerChoice.equals("paper"))
        {
            return "You Win";
        } else if (thePlayersChoice.equals(computerChoice)) {
            return "Draw";
        } else {
            return "Computer Wins";
        }
    }
}

