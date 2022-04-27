package com.engine.core;

import com.engine.game.Game;

import javax.swing.*;
import java.awt.*;

import static com.engine.helpers.Constants.Game.*;

public class Window {
    public Window(Game game) {
        game.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        game.setMaximumSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        game.setMinimumSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

        JFrame frame = new JFrame(GAME_TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
