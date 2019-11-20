package com.inv1ct0;

import com.badlogic.gdx.Game;
import com.inv1ct0.screen.MenuScreen;


public class SpaceWars extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
