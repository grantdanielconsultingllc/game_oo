package com.aca.game.rules;

import java.util.concurrent.ThreadLocalRandom;

import com.aca.game.player.GuessPlayer;

public class GuessRules extends Rules {
    
    public final static int LOWEST_NUMBER = 1;
    public final static int HIGHEST_NUMBER = 100;
        
    
    public static int getRandomNumber() {

    	//We have to pass it a lower and upper value
    	//The first number is the lowest this method will return
    	//The second number is one higher than the highest number this method will return
    	int randomNumber = ThreadLocalRandom.current().nextInt(LOWEST_NUMBER, HIGHEST_NUMBER + 1);
    	return randomNumber;
    }
    
    public static int getGuessFromUser()
    {
        Integer userInt = null;

        do
        {
            System.out.print("Guess my secret number: ");
            String userInput = getUserInput();

            userInt = validateGuess(userInput);

        } while (userInt == null);  //TODO not very readable

        return userInt;
    }
    
    /**
     * Determine if the user input is a valid guess.  It must be an integer within the range.
     * @param userInput
     * @return an Integer containing the user's input. Return null if not valid.
     */
    //TODO refactor to use a regular expression to validate input / remove try/catch
    //TODO this method does too many things - validates and converts to integer.
    private static Integer validateGuess(String userInput) {
    	Integer userInputInt = null;
    	try
         {
    		userInputInt = Integer.parseInt(userInput);
             if (userInputInt < LOWEST_NUMBER || userInputInt > HIGHEST_NUMBER) {
             	System.out.println("I'm sorry. I can't accept that number, number is out of range. Try again.");
             	userInputInt = null;
             }
         }
         catch(Exception e)
         {
             System.out.println("I'm sorry. I can't accept that as an integer. Try again.");            
         }
    	
    	return userInputInt;  //Return null if not valid? not very intuitive
    }
    
    //TODO is this a good method name?
    public static void checkGuess(int randomNumber, GuessPlayer player) {
    	String tooCold = "";
    	
    	int absoluteDiff = Math.abs(player.getGuess() - randomNumber);
    	if (absoluteDiff >= 11) {
    		tooCold = "and too cold!";
    	}
    	
    	if (player.getGuess() < randomNumber) {
    		System.out.println("Too Low " + tooCold);
    	} else if(player.getGuess() > randomNumber) {
    		System.out.println("Too High " + tooCold);
    	} else {
    		System.out.println("Winner Winner Chicken Dinner!");
    		System.out.println(player.getName() + ", " + 
    				"You did it in '" + player.getNumberOfGuessesCurrentGame() + "' guesses");
    	}
    }

	public static void displayRules() {
		System.out.println("");
		System.out.println(separationLine);
		System.out.println("       Guess Game Rules  ");
		System.out.println("A random number between '" + LOWEST_NUMBER + "' ");
		System.out.println("and '" + HIGHEST_NUMBER + "' (inclusive) will be generated.");
		System.out.println("Your goal is to guess the number");
		System.out.println("in the fewest attempts.");
		System.out.println("Let the games begin...");
		System.out.println(separationLine);
		System.out.println("");		
	}

	
    
    
}
