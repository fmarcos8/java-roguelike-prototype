package com.engine.game;

import com.engine.input.KeyInput;
import com.engine.input.MouseInput;
import com.engine.scenes.DebugModeScene;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import static com.engine.helpers.Constants.Game.*;

public class Game extends Canvas implements Runnable {
    public static Game instance = null;
    protected boolean running;
    protected JFrame frame;
    public static DebugModeScene debugModeScene;

    public KeyInput keyInput;
    public MouseInput mouseInput;

    public Game() {
        keyInput = new KeyInput();
        mouseInput = new MouseInput();

        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setMaximumSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setMinimumSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.addKeyListener(keyInput);
        this.addMouseListener(mouseInput);
        this.addMouseMotionListener(mouseInput);

        frame = new JFrame(GAME_TITLE);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        this.requestFocus();
        initGame();
    }

    private void initGame() {
        running = true;
        debugModeScene = new DebugModeScene();
    }

    public static Game getInstance() {
        if (Game.instance == null) {
            Game.instance = new Game();
        }

        return Game.instance;
    }

    public void update() {
        debugModeScene.update();
    }

    public void render(Graphics g) {
        debugModeScene.render(g);
    }

    public void renderOffScreen() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0, getWidth(), getHeight());

        render(g);

        bs.show();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0d / MAX_FPS;
        double timePerUpdate = 1000000000.0d / MAX_UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaTime = 0;
        double deltaFrame = 0;

        while (running) {
            long currentTime = System.nanoTime();

            deltaTime += (currentTime - previousTime) / timePerUpdate;
            deltaFrame += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaTime >= 1) {
                update();
                updates++;
                deltaTime--;
            }

            if (deltaFrame >= 1) {
                renderOffScreen();
                frames++;
                deltaFrame--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                frame.setTitle(GAME_TITLE+" - "+String.format("FPS: %d | UPS: %d", frames, updates));
                frames = 0;
                updates = 0;
            }
        }
    }
}
