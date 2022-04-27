package com.engine.helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Functions {
    public static BufferedImage LoadSprite(String filePath) {
        BufferedImage img = null;
        InputStream is = Functions.class.getResourceAsStream("/"+filePath);
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
                System.exit(-1);
            }
        }

        return img;
    }

    public static double GetAngle(Vector2 p1, Vector2 p2) {
        double dX = (p2.x - p1.x);
        double dY = (p1.y - p2.y);
        double result = Math.toDegrees(Math.atan2(dY, dX));

        return result < 0 ? (360d + result) : result;
    }
}
