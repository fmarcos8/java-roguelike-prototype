package com.engine.components;

import com.engine.core.Component;

import java.awt.*;

public class Aim extends Component {
    public int mX, mY;

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        float[] dashingPattern1 = {5f, 5f};
        Stroke stroke1 = new BasicStroke(
                2f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                1.0f,
                dashingPattern1,
                2.0f
        );

        g2d.setStroke(stroke1);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(
                (int)(parent.transform.position.x + parent.size.width),
                (int)(parent.transform.position.y + parent.size.height),
                mX,
                mY
        );
    }
}
