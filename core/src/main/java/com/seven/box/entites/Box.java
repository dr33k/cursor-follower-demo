package com.seven.box.entites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Box {
    private Vector2 currentPos;
    private Vector2 targetPos;
    private Sprite sprite;

    public Box() {
        currentPos = new Vector2(50f, 50f);
        targetPos = new Vector2(50f, 50f);
        sprite = null;
    }

    public Vector2 getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Vector2 currentPos) {
        this.currentPos = currentPos;
    }

    public Vector2 getTargetPos() {
        return targetPos;
    }

    public void setTargetPos(Vector2 targetPos) {
        this.targetPos = targetPos;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

}
