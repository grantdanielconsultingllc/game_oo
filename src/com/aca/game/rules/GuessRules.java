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
        boolean isValid = false;
        String userInput = null;
        
        do
        {
            System.out.print("Guess my secret number: ");
            userInput = getUserInput();

            isValid = validateGuess2(userInput);            

        } while (!isValid);  //TODO not very readable
        
        userInt = convertGuessToInt(userInput);

        return userInt;
    }
    
    private static Integer convertGuessToInt(String userInput) {
    	Integer userInputInt = null;
    	try
         {
    		userInputInt = Integer.parseInt(userInput);            
         }
         catch(Exception e)
         {                      
         }
    	
    	return userInputInt;  
	}
    
    private static boolean validateGuess2(String userInput) {
    	boolean isValid = true;
    	Integer userInputInt = null;
    	try
         {
    		
//    		boolean isGood = userInput.matches("^[1-9][0-9]$");
    		
    		userInputInt = Integer.parseInt(userInput);
             if (userInputInt < LOWEST_NUMBER || userInputInt > HIGHEST_NUMBER) {
             	System.out.println("I'm sorry. I can't accept that number, number is out of range. Try again.");
             	isValid = false;
             }
         }
         catch(Exception e)
         {
             System.out.println("I'm sorry. I can't accept that as an integer. Try again.");  
             isValid = false;
         }
    	
    	return isValid;  
    }
    
    //TODO is this a good method name?
    public static void displayGuessResult(int randomNumber, GuessPlayer player) {
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
