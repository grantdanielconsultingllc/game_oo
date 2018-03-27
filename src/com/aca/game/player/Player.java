package com.aca.game.player;

public abstract class Player {

	private String name;
	private int numberOfGames = 0;

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
