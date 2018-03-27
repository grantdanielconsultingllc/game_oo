package com.aca.game.player;

import java.util.ArrayList;
import java.util.List;

public class TttPlayer extends Player {

	private List<String> selections = new ArrayList<String>();
	public final TttBoardMarker marker;
	
	public TttPlayer(TttBoardMarker marker) {
		this.marker = marker;
	}

	public void addSelection(String selection) {
		selections.add(selection);
	}
	
	public void newGame() {
		selections = new ArrayList<String>();
	}
	
	public List<String> getSelections() {
		return selections;
	}
	
	@Override
	public String getName() {
		String name = super.getName();
		name = name + "[" + marker.toString() + "]";
		return name;
	}
	
}
