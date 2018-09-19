package com.aca.game.player;

/**
 * Parent class for all specific player types (e.g. GuessPlayer).
 * 
 * @author daniel
 *
 */
public abstract class Player {

	private String name;
	private int numberOfGames = 0;
	
	public abstract void displayTotals();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void incrementNumberOfGames() {
		numberOfGames++;
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}	
	
}
