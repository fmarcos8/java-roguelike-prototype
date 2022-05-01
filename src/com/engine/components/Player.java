package com.engine.components;

import com.engine.core.Component;
import com.engine.core.GameObject;
import com.engine.game.Game;
import com.engine.helpers.*;

import java.awt.*;

import static com.engine.helpers.Constants.*;
import static com.engine.helpers.Constants.Game.GAME_SCALE;
import static com.engine.helpers.Constants.PlayerConstants.SPEED;
import static com.engine.helpers.Constants.PlayerConstants.SPRITE_AMOUNT;

public class Player extends Component {
    private int currentAnimation = PlayerConstants.IDLE_DOWN;
    public boolean FACE_LEFT, FACE_RIGHT, FACE_UP, FACE_DOWN;

    @Override
    public void update() {
        setAnimation();
        updateAnimation();
        movement();
    }

    private void updateAnimation() {
        parent.getComponent(Sprite.class).animTick++;
        if (parent.getComponent(Sprite.class).animTick >= parent.getComponent(Sprite.class).animSpeed) {
            parent.getComponent(Sprite.class).animTick = 0;
            parent.getComponent(Sprite.class).animIndex++;
            if (parent.getComponent(Sprite.class).animIndex == SPRITE_AMOUNT) {
                parent.getComponent(Sprite.class).animIndex = 0;
            }
        }
    }

    private void setAnimation() {
        if (FACE_LEFT) {
            currentAnimation = PlayerConstants.IDLE_LEFT;
        } else if (FACE_RIGHT) {
            currentAnimation = PlayerConstants.IDLE_RIGHT;
        } else if (FACE_UP) {
            currentAnimation = PlayerConstants.IDLE_UP;
        } else if (FACE_DOWN) {
            currentAnimation = PlayerConstants.IDLE_DOWN;
        }
    }

    private void movement() {
        if (!parent.LEFT && !parent.RIGHT && !parent.UP && !parent.DOWN)
            return;

        float xSpeed = 0;
        float ySpeed = 0;

        if (parent.LEFT) {
            xSpeed = -SPEED;
        }
        if (parent.RIGHT) {
            xSpeed = SPEED;
        }
        if (parent.UP) {
            ySpeed = -SPEED;
        }
        if (parent.DOWN) {
            ySpeed = SPEED;
        }

        parent.transform.position.x += xSpeed;
        parent.transform.position.y += ySpeed;
    }

    public void resetDirBooleans() {
        FACE_DOWN = false;
        FACE_UP = false;
        FACE_LEFT = false;
        FACE_RIGHT = false;
    }

    @Override
    public void render(Graphics g) {
        int currSpriteIndex = parent.getComponent(Sprite.class).animIndex;
        g.drawImage(
            parent.getComponent(Sprite.class).getAnimations()[currentAnimation][currSpriteIndex],
            (int)parent.transform.position.x,
            (int)parent.transform.position.y,
            (int)(parent.size.width * GAME_SCALE),
            (int)(parent.size.height * GAME_SCALE),
            null
        );
    }

    public void shoot(Vector2 mousePos) {
        float startX = parent.transform.position.x + parent.size.width * GAME_SCALE / 2;
        float startY = parent.transform.position.y + parent.size.height * GAME_SCALE / 2;

        double dx = mousePos.x - startX;
        double dy = mousePos.y - startY;
        double dir = Math.atan2(dy, dx);

        GameObject projectile = new GameObject(ObjectType.PROJECTILE, new Transform(new Vector2(startX, startY)), new Size(25, 25));
        projectile.addComponent(new Projectile(new Vector2(startX, startY), dir));

        Game.debugModeScene.addObject(projectile);
    }
}
