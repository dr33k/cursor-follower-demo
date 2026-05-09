package com.seven.box.systems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.seven.GameApp;
import com.seven.box.assets.Constants;
import com.seven.box.entites.Box;
import com.seven.box.screens.BoxScreen;

public class RenderSystem {
    private final GameApp game;
    private final FitViewport viewport;

    public RenderSystem(GameApp game, FitViewport viewport) {
        this.game = game;
        this.viewport = viewport;
    }

    public void render(BoxScreen screen) {
        viewport.apply();

        Box box = screen.getBox();

        if(TrackingConfig.isBoxNearCursor(screen, Constants.MIN_DISTANCE_FOR_COLOUR_UPDATE)){
            ScreenUtils.clear(Color.GREEN);
        }else{
            ScreenUtils.clear(Color.BLACK);
        }

        SpriteBatch spriteBatch = game.getBatch();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        spriteBatch.begin();

        box.getSprite().draw(spriteBatch);

        spriteBatch.end();

    }
}
