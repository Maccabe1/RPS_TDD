package com.example.rpsgame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private Computer computer;

    public WebController(Computer computer) {
        this.computer = computer;
    }

    @GetMapping("/playagame")
    public String playGame(
            @RequestParam(name="choice", required=false) String thePlayersChoice,
            Model model
    ){
        String computerRandomChoice = computer.getComputerChoice();

        if (thePlayersChoice == null) {
            return "index";
        }

        String theOutcome;

        if(thePlayersChoice.equals("rock") && computerRandomChoice.equals("scissors") ||
                thePlayersChoice.equals("paper") && computerRandomChoice.equals("rock") ||
                thePlayersChoice.equals("scissors") && computerRandomChoice.equals("paper")){
            theOutcome = "You Win";
        } else if(thePlayersChoice.equals(computerRandomChoice)){
            theOutcome = "Draw";
        } else {
            theOutcome = "Computer Wins";
        }

        model.addAttribute("personChoice", thePlayersChoice);
        model.addAttribute("computerChoice", computerRandomChoice);
        model.addAttribute("outcome", theOutcome);

        return "results";
    }
}

