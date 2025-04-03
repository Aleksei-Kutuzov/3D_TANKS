package com.alkut.game3dtanks.screens;

import com.alkut.game3dtanks.Main;
import com.alkut.game3dtanks.model.Item;
import com.alkut.game3dtanks.model.World;
import com.alkut.game3dtanks.view.WorldRender;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
    private Main game;
    private World world;
    private WorldRender worldRender;

    public GameScreen(Main game) {
        this.game = game;
        world = new World();
        world.items.add(new Item());
        worldRender = new WorldRender(world);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        worldRender.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        worldRender.dispose();
    }
}
