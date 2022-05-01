package com.engine.helpers;

public class Constants {
    public static class Game {
        public static final float GAME_SCALE = 2.0f;
        public static final int TILES_DEFAULT_SIZE = 32;
        public static final int COUNT_TILES_IN_WIDTH = 26;
        public static final int COUNT_TILES_IN_HEIGHT = 14;
        public static final int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * GAME_SCALE);
        public static final int GAME_WIDTH = TILES_SIZE * COUNT_TILES_IN_WIDTH;
        public static final int GAME_HEIGHT = TILES_SIZE * COUNT_TILES_IN_HEIGHT;
        public static final String GAME_TITLE = "Roguelike 0.1v";

        public static final int MAX_FPS = 60;
        public static final int MAX_UPS = 120;
    }

    public static class PlayerConstants {
        //SPRITES
        public static final String PLAYER_SPRITE_PATH = "assets/sprites/player/player_idle.png";

        //SIZE
        public static final float SPEED = 4;
        public static final int WIDTH = 64;
        public static final int HEIGHT = 64;

        //ANIMATIONS
        public static final int IDLE_DOWN = 0;
        public static final int IDLE_LEFT = 1;
        public static final int IDLE_RIGHT = 2;
        public static final int IDLE_UP = 3;

        public static final int SPRITE_AMOUNT = 4;
    }

    public static class Bullet {
        public static final String SPRITE_PATH = "assets/sprites/bullet/bullet.png";

        public static final float SPEED = 4;
        public static final int WIDTH = 32;
        public static final int HEIGHT = 32;
    }
}
