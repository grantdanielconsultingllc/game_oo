package com.aca.game.player;

public enum TttBoardMarker { X,O;
	
	public static boolean isValid(String value) {
		boolean isValid = false;
		
		if (TttBoardMarker.X.toString().equalsIgnoreCase(value)) {
			isValid = true;
		} else if (TttBoardMarker.O.toString().equalsIgnoreCase(value)) {
			isValid = true;
		}
		
		return isValid;
	}
}
