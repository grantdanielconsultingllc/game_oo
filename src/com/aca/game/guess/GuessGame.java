package com.aca.game.guess;

import com.aca.game.Game;
import com.aca.game.player.GuessPlayer;
import com.aca.game.rules.GuessRules;

public class GuessGame extends Game {

	private GuessPlayer myPlayer = new GuessPlayer();
	int randomNumber = 0;
	
	public static void main(String[] args) {		
		Game myGame = new GuessGame();
		myGame.setName("The World's Best Guess Game");	
		myGame.welcomeToGame();
		myGame.play();
	}

	@Override
	public void play() {
		
		GuessRules.displayRules();
		
		myPlayer.setName(GuessRules.getNameFromUser());	
		
		do {
			myPlayer.startNewGame();
			randomNumber = GuessRules.getRandomNumber();
			
			do {

				myPlayer.setGuess(GuessRules.getGuessFromUser());
				GuessRules.displayGuessResult(randomNumber, myPlayer);	//TODO this is not returning a value, seems odd		

			} while(isGameOver());		//TODO why are we checking if guess == random-number again?	
			
		} while (GuessRules.playAgain());
		
		myPlayer.displayTotals(); 
		
	}	
	
	private boolean isGameOver() {
		boolean gameOver = randomNumber != myPlayer.getGuess();
		return gameOver;
	}

}
