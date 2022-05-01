package com.engine.scenes;

import com.engine.components.Aim;
import com.engine.components.BoxCollider2D;
import com.engine.components.Player;
import com.engine.components.Sprite;
import com.engine.core.GameObject;
import com.engine.core.Scene;
import com.engine.helpers.*;

import java.awt.Graphics;

import static com.engine.helpers.Constants.*;
import static com.engine.helpers.Constants.Game.*;

public class DebugModeScene extends Scene {

    public DebugModeScene() {
        init();
    }

    public void init() {
        GameObject player = new GameObject(
            ObjectType.PLAYER,
            new Transform(new Vector2(0, 0)),
            new Size(
                PlayerConstants.WIDTH * GAME_SCALE,
                PlayerConstants.HEIGHT * GAME_SCALE
            )
        );
        player.addComponent(new Player());
        player.addComponent(new Sprite(PlayerConstants.PLAYER_SPRITE_PATH, PlayerConstants.WIDTH, PlayerConstants.HEIGHT));
        player.addComponent(new BoxCollider2D((int)(PlayerConstants.WIDTH * GAME_SCALE * 2), (int)(PlayerConstants.HEIGHT * GAME_SCALE * 2), false));
        player.addComponent(new Aim());
        addObject(player);
    }

    @Override
    public void update() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update();
        }
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }
}
