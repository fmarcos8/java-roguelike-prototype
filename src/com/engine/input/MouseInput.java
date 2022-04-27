package com.engine.input;

import com.engine.components.Aim;
import com.engine.components.Player;
import com.engine.core.GameObject;
import com.engine.game.Game;
import com.engine.helpers.ObjectType;
import com.engine.helpers.Vector2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static com.engine.helpers.Constants.Game.GAME_SCALE;
import static com.engine.helpers.Functions.GetAngle;

public class MouseInput implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (Game.debugModeScene != null) {
            for (GameObject object: Game.debugModeScene.objects) {
                if (object.type == ObjectType.PLAYER) {
                    object.getComponent(Aim.class).mX = e.getX();
                    object.getComponent(Aim.class).mY = e.getY();

                    object.getComponent(Player.class).resetDirBooleans();

                    float playerX = object.transform.position.x + (object.size.width * GAME_SCALE) / 2;
                    float playerY = object.transform.position.y + (object.size.height * GAME_SCALE) / 2;

                    double angle = GetAngle(new Vector2(e.getX(), e.getY()), new Vector2(playerX, playerY));
                    if (angle >= 45 && angle < 135) {
                        object.getComponent(Player.class).FACE_DOWN = true;
                    } else if (angle >= 135 && angle < 225) {
                        object.getComponent(Player.class).FACE_RIGHT = true;
                    } else if (angle >= 225 && angle < 315) {
                        object.getComponent(Player.class).FACE_UP = true;
                    } else if ((angle >= 315 && angle <= 360) || (angle >= 0 && angle < 45)) {
                        object.getComponent(Player.class).FACE_LEFT = true;
                    }
                }
            }
        }
    }
}
