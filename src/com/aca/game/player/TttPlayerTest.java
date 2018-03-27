package com.aca.game.player;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TttPlayerTest {
 
	@Test
	public void nameTest() {
		String finalName = "lazenby[X]";
			
		TttPlayer myPlayer = new TttPlayer(TttBoardMarker.X);
		myPlayer.setName("lazenby");
		
		Assert.assertEquals(myPlayer.getName(), finalName);
	}
	
	@Test
	public void constructorTest() {
	
		TttPlayer myPlayer = new TttPlayer(TttBoardMarker.X);
		
		Assert.assertEquals(myPlayer.marker, TttBoardMarker.X);
		
		myPlayer = new TttPlayer(TttBoardMarker.O);
		
		Assert.assertEquals(myPlayer.marker, TttBoardMarker.O);
	}
		
}
