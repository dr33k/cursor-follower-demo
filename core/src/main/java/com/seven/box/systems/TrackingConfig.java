package com.seven.box.systems;

import com.badlogic.gdx.math.Vector2;
import com.seven.box.assets.Constants;
import com.seven.box.entites.Box;
import com.seven.box.screens.BoxScreen;

public class TrackingConfig {
    private static Box box;
    private static Vector2 currentPos;
    private static Vector2 targetPos;
    private static final Vector2 direction = new Vector2();

    public static boolean shouldFollowCursor(BoxScreen screen) {
           return screen.getPlatformHook().isMouseInWindow() && !isBoxNearCursor(screen, Constants.EPSILON);
    }

    public static boolean isBoxNearCursor(BoxScreen screen, float epsilon) {
        box = screen.getBox();
        currentPos = box.getCurrentPos();
        targetPos = box.getTargetPos();

        return !screen.isInitialState() &&
            screen.getPlatformHook().isMouseInWindow() &&
            direction.set(targetPos).sub(currentPos).len() < epsilon;
    }
}
