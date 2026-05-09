package com.seven;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seven.box.hooks.PlatformHook;
import com.seven.box.screens.BoxScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameApp extends Game {
    private SpriteBatch batch;
    private Pixmap boxPM;

    private final PlatformHook platformHook;

    public GameApp(PlatformHook platformHook) {
        this.platformHook = platformHook;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();

        boxPM = new Pixmap(com.seven.box.assets.Constants.BOX_EDGE, com.seven.box.assets.Constants.BOX_EDGE, Pixmap.Format.RGBA8888);
        boxPM.setColor(Color.WHITE);
        boxPM.fillRectangle(0,0,com.seven.box.assets.Constants.BOX_EDGE,com.seven.box.assets.Constants.BOX_EDGE);

        this.setScreen(new BoxScreen(this, platformHook));
    }

    @Override
    public void dispose() {
        batch.dispose();
        boxPM.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }


    public Pixmap getBoxPM() {
        return boxPM;
    }
}
