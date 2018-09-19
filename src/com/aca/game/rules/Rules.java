package com.aca.game.rules;

import java.util.Scanner;

public abstract class Rules {	
	
	public final static String separationLine = "++++++++++++++++++++++++++++++++++++++";	
	
	public static String getNameFromUser()
    {
        System.out.print("What is your name? ");
        String userInput = getUserInput();
        return userInput;
    }
	
	//TODO close scanner before returning
    public static String getUserInput()
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }
    
    //TODO refactor to use one return statement
    //TODO consider other options to indicate 'game over'
    public static boolean playAgain() {
    	boolean playAgain = true;
    	
		String answer = askToPlayAgain();
		if (answer.equalsIgnoreCase("Q") || answer.equalsIgnoreCase("quit")) {
			playAgain = false;
		}
		System.out.println(separationLine);
		System.out.println("");
		return playAgain;
	}
    
  //TODO move this private helper method to the end of the class
  	private static String askToPlayAgain()
      {
          System.out.println(separationLine);
  		System.out.print("Type 'Q' to quit. ");
          String userInput = getUserInput();
          return userInput;
      }
    
}
