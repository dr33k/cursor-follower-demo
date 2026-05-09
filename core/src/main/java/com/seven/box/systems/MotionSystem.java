package com.seven.box.systems;

import com.badlogic.gdx.math.Vector2;
import com.seven.box.assets.Constants;
import com.seven.box.entites.Box;
import com.seven.box.screens.BoxScreen;

public class MotionSystem {

    private final Vector2 direction;

    public MotionSystem() {
        direction = new Vector2();
    }

    public void update(BoxScreen screen, float delta) {
        Box box = screen.getBox();
        Vector2 currentPos = box.getCurrentPos();
        Vector2 targetPos = box.getTargetPos();

        if (TrackingConfig.shouldFollowCursor(screen)) {
            direction.set(targetPos).sub(currentPos);

            float len = direction.len();

            if (len > Constants.EPSILON) {
                float ppf = Constants.GAME_SPEED * delta;

                if (ppf >= len) { //snap
                    currentPos.set(targetPos);
                } else {
                    //normalize and scale
                    direction.nor().scl(ppf);
                    currentPos.add(direction);
                }
                box.getSprite().setCenter(currentPos.x, currentPos.y);

                if (screen.isInitialState()) {
                    screen.setInitialState(false);
                }
            }
        } else {
            targetPos.set(currentPos);
        }

    }

}
