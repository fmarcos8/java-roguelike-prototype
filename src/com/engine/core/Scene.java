package com.engine.core;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
    public List<GameObject> objects;

    public Scene() {
        this.objects = new ArrayList<>();
    }

    public void init() {

    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public void removeObject(GameObject object) {
        for (int i = 0; i < object.components.size(); i++) {
            object.removeComponent(object.components.get(i));
        }

        objects.remove(object);
    }

    public abstract void update();
    public abstract void render(Graphics g);

}
