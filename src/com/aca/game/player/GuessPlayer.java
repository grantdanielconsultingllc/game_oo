package com.aca.game.player;

import com.aca.game.rules.Rules;

/**
 * This class encapsulates guess player statistics and guess value.
 * 
 * @author daniel
 *
 */
public class GuessPlayer extends Player {
	
	private int guess = 0;
	private int numberOfGuessesCurrentGame = 0; 
	private int totalGuessesAllGames = 0; 	
	
	public int getGuess() {
		return guess;
	}
	
	public void setGuess(int guess) {
		this.guess = guess;
		numberOfGuessesCurrentGame++;
		totalGuessesAllGames++;
	}
	
	public int getNumberOfGuessesCurrentGame() {
		return numberOfGuessesCurrentGame;
	}	
	
	public void startNewGame() {
		numberOfGuessesCurrentGame = 0;
		this.incrementNumberOfGames();
	}

	public int getTotalGuessesAllGames() {
		return totalGuessesAllGames;
	}
	
	//TODO add code to calculate and display averages
	//TODO is this a good method name?  what kind of totals are these?
	@Override
	public void displayTotals() {
		System.out.println("");
		System.out.println(Rules.separationLine); //TODO convert to use Rules.separationLine 
		System.out.println(getName() + ", thanks for playing!");
		System.out.println("Your total guesses are: " + getTotalGuessesAllGames() + "'.");
		System.out.println("Your ave guesses per game: " + getAverage() + "'.");
	}
	
	private double getAverage() {		
		return this.totalGuessesAllGames / this.getNumberOfGames();
	}
	
}
