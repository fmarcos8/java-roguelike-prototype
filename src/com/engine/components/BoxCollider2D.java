package com.engine.components;

import com.engine.core.Component;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class BoxCollider2D extends Component {
    private boolean show;
    private Rectangle2D.Float hitBox;
    public int width;
    public int height;

    public BoxCollider2D(boolean show) {
        this.show = show;
    }

    public BoxCollider2D(int width, int height, boolean show) {
        this.show = show;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        if (show) {
            g.setColor(Color.GREEN);
            g.drawRect((int)getHitBox().x,(int)getHitBox().y,(int)getHitBox().width,(int)getHitBox().height);
        }
    }

    public Rectangle2D.Float getHitBox() {
        return new Rectangle2D.Float(
                parent.transform.position.x,
                parent.transform.position.y,
                width,
                height
        );
    }

}
