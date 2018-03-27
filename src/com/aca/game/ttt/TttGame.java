package com.aca.game.ttt;

import java.util.ArrayList;
import java.util.List;

import com.aca.game.Game;
import com.aca.game.player.TttBoardMarker;
import com.aca.game.player.TttPlayer;
import com.aca.game.rules.TttRules;

public class TttGame extends Game {

	private TttPlayer player1 = new TttPlayer(TttBoardMarker.X);
	private TttPlayer player2 = new TttPlayer(TttBoardMarker.O);
	private TttPlayer activePlayer;
	
	private int totalSelections = 0;
	
	private List<String> tttBoard;
	
	public static void main(String[] args) {
		TttGame tttGame = new TttGame();
		tttGame.setName("Tic Tac Toe");
		tttGame.welcomeToGame();
		tttGame.play();
	}

	@Override
	public void play() {	
			
		player1.setName(TttRules.getNameFromUser());
		player2.setName(TttRules.getNameFromUser());
		
		do {
			startNewGame();
			
			do {
				
				getNextPlayer();
				
				String selection = TttRules.selectBox(activePlayer.getName(), tttBoard);
				activePlayer.addSelection(selection);
				updateBoard(selection, activePlayer.marker);
				
				TttRules.printGid(tttBoard);			
			
			} while (continueGame());
		} while (TttRules.playAgain());
		
	}

	private void startNewGame() {
		totalSelections = 0;
		initializeBoard();
		TttRules.printGid(tttBoard);
		player1.newGame();
		player2.newGame();
	}

	private boolean continueGame() {
		boolean continueGame = true;
		boolean isWinner = TttRules.isWinner(activePlayer.getSelections());
		if (isWinner) {
			System.out.println(activePlayer.getName() + " you are the winner!!!");	
			continueGame = false;
		} else if (isDraw()) {
			System.out.println("Sorry, game ends in a draw");	
			continueGame = false;
		}
		return continueGame;
	}
	
	private void getNextPlayer() {
		if (activePlayer == null) {
			activePlayer = player1;
		} else if (activePlayer == player1) {
			activePlayer = player2;
		} else {
			activePlayer = player1;
		}		
	}

	private void updateBoard(String selection, TttBoardMarker marker) {
		int index = tttBoard.indexOf(selection.toUpperCase());
		tttBoard.set(index, marker.toString());	
		totalSelections++;
	}

	private void initializeBoard() {
		tttBoard = new ArrayList<String>();
		
		tttBoard.add("A1");
		tttBoard.add("A2");
		tttBoard.add("A3");
		tttBoard.add("B1");
		tttBoard.add("B2");
		tttBoard.add("B3");
		tttBoard.add("C1");
		tttBoard.add("C2");
		tttBoard.add("C3");
	}
	
	@Override
	public void welcomeToGame() {
		super.welcomeToGame();
		System.out.println("Two player names are required");	
	}
	
	private boolean isDraw() {
		boolean isDraw = false;
		if (totalSelections == 9) {
			isDraw = true;
		}
		return isDraw;
	}
	

}
