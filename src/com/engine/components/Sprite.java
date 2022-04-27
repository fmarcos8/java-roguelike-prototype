package com.engine.components;

import com.engine.core.Component;
import com.engine.helpers.Functions;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends Component {
    private BufferedImage sprite;
    private BufferedImage subSprite;
    private static BufferedImage[][] animations;
    public int animTick;
    public int animIndex;
    public int animSpeed = 20;

    private String filePath;
    private int subWidth;
    private int subHeight;

    public Sprite(String filePath, int subWidth, int subHeight) {
        this.filePath = filePath;
        this.subWidth = subWidth;
        this.subHeight = subHeight;
        this.sprite = Functions.LoadSprite(filePath);

        loadAnimations();
    }

    private void loadAnimations() {
        int cols = sprite.getHeight() / subHeight;
        int rows = sprite.getWidth() / subWidth;

        animations = new BufferedImage[cols][rows];

        for (int y = 0; y < animations.length; y++) {
            for (int x = 0; x < animations[y].length; x++) {
                animations[y][x] = sprite.getSubimage(x * subWidth, y * subHeight, subWidth, subHeight);
            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }

    public BufferedImage[][] getAnimations() {
        return animations;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public BufferedImage getSubSprite() {
        return subSprite;
    }
}
