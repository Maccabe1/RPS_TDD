package com.example.rpsgame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private Computer computer;
    private Cheater cheater;

    public WebController(Computer computer, Cheater cheater) {

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

        switch (theOpponentType) {

            case "computer":

                String computerRandomChoice = computer.getComputerChoice();
                String theOutcome;

                if (
                    thePlayersChoice.equals("rock") && computerRandomChoice.equals("scissors") ||
                    thePlayersChoice.equals("paper") && computerRandomChoice.equals("rock") ||
                    thePlayersChoice.equals("scissors") && computerRandomChoice.equals("paper"))
                {
                    theOutcome = "You Win";
                } else if (thePlayersChoice.equals(computerRandomChoice)) {
                    theOutcome = "Draw";
                } else {
                    theOutcome = "Computer Wins";
                }

                model.addAttribute("opponentType", theOpponentType);
                model.addAttribute("personChoice", thePlayersChoice);
                model.addAttribute("computerChoice", computerRandomChoice);
                model.addAttribute("outcome", theOutcome);

                return "results";

            case "cheater":

                String computerCheats = cheater.setCheaterChoice(thePlayersChoice);

                if (
                    thePlayersChoice.equals("rock") ||
                    thePlayersChoice.equals("paper") ||
                    thePlayersChoice.equals("scissors"))
                {
                    cheater.setCheaterChoice(thePlayersChoice);
                    theOutcome = "Computer Wins";

                    model.addAttribute("opponentType", theOpponentType);
                    model.addAttribute("personChoice", thePlayersChoice);
                    model.addAttribute("computerChoice", computerCheats);
                    model.addAttribute("outcome", theOutcome);
                    return "results";
                }
        }
        return "index";
    }
}

