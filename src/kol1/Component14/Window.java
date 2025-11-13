package kol1.Component14;

import java.util.Map;
import java.util.TreeMap;

public class Window {
    private String name;
    private Map<Integer, Component> components;

    public Window(String name) {
        this.name = name;
        components = new TreeMap<>();
    }

    void addComponent(int position, Component component) throws InvalidPositionException {
        if (components.containsKey(position)) {
            throw new InvalidPositionException(position);
        }
        components.put(position, component);
    }

    void changeColor(int weight, String color) {
        components.values().forEach(c -> c.changeColor(weight, color));
    }

    void swichComponents(int pos1, int pos2) {
        Component c1 = components.get(pos1);
        Component c2 = components.get(pos2);

        if (c1 != null && c2 != null) {
            components.put(pos1, c2);
            components.put(pos2, c1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WINDOW ").append(name).append("\n");
        components.forEach((pos, comp) ->{
            sb.append(pos).append(":").append(comp.toString()).append("\n");
        } );
        return sb.toString();
    }
}
