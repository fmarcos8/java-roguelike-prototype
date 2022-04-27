package com.engine.input;

import com.engine.core.GameObject;
import com.engine.game.Game;
import com.engine.helpers.ObjectType;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends KeyAdapter implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        for (GameObject object: Game.debugModeScene.objects) {
            if (object.type == ObjectType.PLAYER) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    object.LEFT = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    object.RIGHT = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    object.UP = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    object.DOWN = true;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (GameObject object: Game.debugModeScene.objects) {
            if (object.type == ObjectType.PLAYER) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    object.LEFT = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    object.RIGHT = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    object.UP = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    object.DOWN = false;
                }
            }
        }
    }
}
