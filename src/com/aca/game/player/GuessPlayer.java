package com.aca.game.player;

public class GuessPlayer extends Player {

	//TODO are variable names too long?
	private int guess = 0;
	private int numberOfGuessesCurrentGame = 0; //for each game
	private int totalGuessesAllGames = 0; //for all games	
	
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
	}

	public int getTotalGuessesAllGames() {
		return totalGuessesAllGames;
	}
	
	//TODO add code to calculate and display averages
	//TODO is this a good method name?  what kind of totals are these?
	public void displayTotals() {
		System.out.println("");
		System.out.println("++++++"); //TODO convert to use Rules.separationLine 
		System.out.println(getName() + ", thanks for playing!");
		System.out.println("Your total guesses are: " + getTotalGuessesAllGames() + "'.");		
	}
	
}
