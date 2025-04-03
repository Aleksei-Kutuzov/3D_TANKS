package com.alkut.game3dtanks;

import com.alkut.game3dtanks.screens.GameScreen;
import com.alkut.game3dtanks.screens.MenuScreen;
import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public GameScreen game;
    public MenuScreen menu;
    @Override
    public void create() {
        game = new GameScreen(this);
        menu = new MenuScreen(this);
        setScreen(game);
    }
}
