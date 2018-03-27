package com.aca.game;

public abstract class Game {

	//TODO consider setting the name in a constructor
	private String name;
	
	//TODO consider making owners static
	private final String owners = "ACA Part-Timers";
	
	public abstract void play();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwners() {
		return owners;
	}
	
	//TODO make copyrighted date a static variable
	//TODO is this a good method name?... what is it doing?
	public void welcomeToGame() {
		System.out.println("Welcome to " + getName());	
		System.out.println("Copyrighted 2017 - " + getOwners());	
	}
	
}
