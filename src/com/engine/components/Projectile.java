package com.engine.components;

import com.engine.core.Component;
import com.engine.game.Game;
import com.engine.helpers.Constants;
import com.engine.helpers.Functions;
import com.engine.helpers.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.engine.helpers.Constants.Bullet.*;
import static com.engine.helpers.Constants.Game.*;

public class Projectile extends Component {
    public Vector2 position;
    public double angle, dx, dy;
    private BufferedImage bulletSprite;

    public Projectile(Vector2 position, double angle) {
        this.position = position;
        this.angle = angle;
        bulletSprite = Functions.LoadSprite(SPRITE_PATH);

        dx = Math.cos(angle);
        dy = Math.sin(angle);
    }

    @Override
    public void update() {
        position.x += dx * GAME_SCALE * 4;
        position.y += dy * GAME_SCALE * 4;

        if ((position.x + 25 < 0 || position.x > GAME_WIDTH) || (position.y + 25 < 0 || position.y > GAME_HEIGHT)) {
            Game.debugModeScene.removeObject(parent);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bulletSprite, (int)(position.x - (WIDTH/2)), (int)(position.y - (HEIGHT/2)), (int)(WIDTH * GAME_SCALE), (int)(HEIGHT * GAME_SCALE),  null);

    }
}
