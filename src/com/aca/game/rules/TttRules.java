package com.aca.game.rules;

import java.util.List;
import com.aca.game.player.TttBoardMarker;

public class TttRules extends Rules {

	public static void printGid(List<String> grid) {
		System.out.println("-------------------------");
		System.out.println("|" +  "\t|" + "\t|" + "\t|");
		System.out.println("|" + pad(grid.get(0)) + "\t|" + pad(grid.get(1)) + "\t|" + pad(grid.get(2)) + "\t|");
		System.out.println("|" + "\t|" + "\t|" + "\t|");
		System.out.println("-------------------------");
		System.out.println("|" + "\t|" + "\t|" + "\t|");
		System.out.println("|" + pad(grid.get(3)) + "\t|" + pad(grid.get(4)) + "\t|" + pad(grid.get(5)) + "\t|");
		System.out.println("|" + "\t|" + "\t|" + "\t|");
		System.out.println("-------------------------");
		System.out.println("|" + "\t|" + "\t|" + "\t|");
		System.out.println("|" + pad(grid.get(6)) + "\t|" + pad(grid.get(7)) + "\t|" + pad(grid.get(8)) + "\t|");
		System.out.println("|" + "\t|" + "\t|" + "\t|");
		System.out.println("-------------------------");		
	}
	
	private static String pad(String value) {
		return "  " + value + "  ";
	}
	
	/**
	 * indexOf will return a positive int if the value is found.
	 * a marker value can not be selected.
	 */
	private static boolean isValidSelections(String gridValue, List<String> grid) {
		boolean isValid = false;
		
		if (TttBoardMarker.isValid(gridValue)) {
			//make sure they don't select X or O
			isValid = false;
		} else if (grid.indexOf(gridValue.toUpperCase()) >= 0) {
			isValid = true;
		}		
	
		return isValid;
	}
	
	public static String selectBox(String name, List<String> grid) {
		String selection = "";
		boolean askAgain = true;
		
		do {
			System.out.println("Player " + name + ", please make selection");
			selection = Rules.getUserInput();
			
			if (isValidSelections(selection, grid)) {
				askAgain = false;
			} else {
				System.out.println("Not a valid selection");
			}
		
		} while (askAgain);
		
		
		return selection.toUpperCase();
	}
	
	public static boolean isWinner(List<String> playerSelections) {
		boolean isWinner = false;

		if (playerSelections.contains("A1") && playerSelections.contains("A2") && playerSelections.contains("A3")) {
			isWinner = true;
		} else if (playerSelections.contains("A1") && playerSelections.contains("B1") && playerSelections.contains("C1")) {
			isWinner = true;
		} else if (playerSelections.contains("A1") && playerSelections.contains("B2") && playerSelections.contains("C3")) {
			isWinner = true;
		} else if (playerSelections.contains("A2") && playerSelections.contains("B2") && playerSelections.contains("C2")) {
			isWinner = true;
		} else if (playerSelections.contains("A3") && playerSelections.contains("B3") && playerSelections.contains("C3")) {
			isWinner = true;
		} else if (playerSelections.contains("A3") && playerSelections.contains("B2") && playerSelections.contains("C1")) {
			isWinner = true;
		} else if (playerSelections.contains("B1") && playerSelections.contains("B2") && playerSelections.contains("B3")) {
			isWinner = true;
		} else if (playerSelections.contains("C1") && playerSelections.contains("C2") && playerSelections.contains("C3")) {
			isWinner = true;
		}

		return isWinner;		
	}

		
}
