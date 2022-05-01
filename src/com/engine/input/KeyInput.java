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
        for (int i = 0; i < Game.debugModeScene.getObjects().size(); i++) {
            if (Game.debugModeScene.getObjects().get(i).type == ObjectType.PLAYER) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    Game.debugModeScene.getObjects().get(i).LEFT = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    Game.debugModeScene.getObjects().get(i).RIGHT = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    Game.debugModeScene.getObjects().get(i).UP = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    Game.debugModeScene.getObjects().get(i).DOWN = true;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (int i = 0; i < Game.debugModeScene.getObjects().size(); i++) {
            if (Game.debugModeScene.getObjects().get(i).type == ObjectType.PLAYER) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    Game.debugModeScene.getObjects().get(i).LEFT = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    Game.debugModeScene.getObjects().get(i).RIGHT = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    Game.debugModeScene.getObjects().get(i).UP = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    Game.debugModeScene.getObjects().get(i).DOWN = false;
                }
            }
        }
    }
}
