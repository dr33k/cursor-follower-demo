package com.seven.lwjgl3.hook_impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.seven.box.hooks.PlatformHook;
import org.lwjgl.glfw.GLFW;

public class DesktopHook implements PlatformHook {
    @Override
    public boolean isMouseInWindow() {
//        int windowX = ((Lwjgl3Graphics) Gdx.graphics).getWindow().getPositionX();
//        int windowY = ((Lwjgl3Graphics) Gdx.graphics).getWindow().getPositionY();
//
//        int cursorX = Gdx.input.getX();
//        int cursorY = Gdx.input.getY();
//
//        return cursorX > 0 && cursorX < Gdx.graphics.getWidth() &&
//            cursorY > 0 && cursorY < Gdx.graphics.getHeight();

        // 1. Get the LWJGL window handle
        long windowHandle = ((Lwjgl3Graphics) Gdx.graphics).getWindow().getWindowHandle();

        // 2. Check the window attribute for "HOVERED"
        // This returns 1 if the mouse is over the content area, 0 otherwise.
        return GLFW.glfwGetWindowAttrib(windowHandle, GLFW.GLFW_HOVERED) == GLFW.GLFW_TRUE;
    }
}
