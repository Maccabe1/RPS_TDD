package com.example.rpsgame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;
@Controller
public class WebController {
    @GetMapping("/playagame")
    public String playGame(@RequestParam(name="choice", required=false) String thePlayersChoice, Model model){

        String[] computersChoice = {"rock","paper","scissors"};
        String computerRandomChoice = (computersChoice[new Random().nextInt(computersChoice.length)]);

        if (thePlayersChoice == null) {
            return "index";
        } String theOutcome = "error";

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

