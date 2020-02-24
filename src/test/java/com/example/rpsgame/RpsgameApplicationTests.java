package com.example.rpsgame;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class RpsgameApplicationTests {
	@Test
	public void RockBeatsScissors(){
		WebController newGame = new WebController();
		Model model = null;
		String thePlayersChoice = "rock";
		String computerRandomChoice = "scissors";
		String theOutcome = "You Win";

		assertEquals(newGame.playGame(thePlayersChoice, (Model) model.getAttribute(computerRandomChoice)), theOutcome, theOutcome);


	}

}
