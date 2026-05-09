package com.seven.box.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.seven.GameApp;
import com.seven.box.assets.Constants;
import com.seven.box.entites.Box;
import com.seven.box.hooks.PlatformHook;
import com.seven.box.systems.MotionSystem;
import com.seven.box.systems.RenderSystem;

public class BoxScreen implements Screen, InputProcessor {
    private final GameApp game;
    private final FitViewport viewport;
    private final MotionSystem motionSystem;
    private final RenderSystem renderSystem;
    private final Box box;
    private boolean initialState;
    private PlatformHook platformHook;


    public BoxScreen(GameApp game, PlatformHook platformHook) {
        this.game = game;
        this.platformHook = platformHook;
        this.viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        this.motionSystem = new MotionSystem();
        this.renderSystem = new RenderSystem(game, viewport);
        initialState = true;

        box = new Box();
        Sprite boxSprite = new Sprite(new Texture(game.getBoxPM()));
        boxSprite.setPosition(box.getCurrentPos().x, box.getCurrentPos().y);
        box.setSprite(boxSprite);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        motionSystem.update(this, delta);
        renderSystem.render(this);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Vector2 targetPos = box.getTargetPos();
        targetPos.set(screenX, screenY);
        viewport.unproject(targetPos);

        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public Box getBox() {
        return box;
    }

    public FitViewport getViewport() {
        return viewport;
    }

    public boolean isInitialState() {
        return initialState;
    }

    public void setInitialState(boolean initialState) {
        this.initialState = initialState;
    }

    public PlatformHook getPlatformHook() {
        return platformHook;
    }

    public void setPlatformHook(PlatformHook platformHook) {
        this.platformHook = platformHook;
    }
}
