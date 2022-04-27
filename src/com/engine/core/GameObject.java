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
    private final List<Component> components;
    public boolean UP, DOWN, LEFT, RIGHT, moving;

    public GameObject(ObjectType type, Transform transform, Size size) {
        this.type = type;
        this.transform = transform;
        this.size = size;
        components = new ArrayList<>();
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component component: components) {
            if (componentClass.isAssignableFrom(component.getClass())) {
                try {
                    return componentClass.cast(component);
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

    public void update() {
        for (Component component : components) {
            component.update();
        }
    }

    public void render(Graphics g) {
        for (Component component : components) {
            component.render(g);
        }
    }
}
