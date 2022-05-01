package com.engine.core;

import com.engine.helpers.ObjectType;
import com.engine.helpers.Size;
import com.engine.helpers.Transform;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    public ObjectType type;
    public Transform transform;
    public Size size;
    public List<Component> components;
    public boolean UP, DOWN, LEFT, RIGHT, moving;

    public GameObject(ObjectType type, Transform transform, Size size) {
        this.type = type;
        this.transform = transform;
        this.size = size;
        components = new ArrayList<>();
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (int i = 0; i < components.size(); i++) {
            if (componentClass.isAssignableFrom(components.get(i).getClass())) {
                try {
                    return componentClass.cast(components.get(i));
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }
        return null;
    }

    public void addComponent(Component component) {
        component.parent = this;
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }


    public void update() {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).update();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).render(g);
        }
    }
}
