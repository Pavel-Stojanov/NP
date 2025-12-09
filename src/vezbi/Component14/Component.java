package vezbi.Component14;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Component implements Comparable<Component> {
    private String color;
    private int weight;
    private TreeSet<Component> components;

    public Component(String color, int weight) {
        this.color = color;
        this.weight = weight;
        components = new TreeSet<>();
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    void changeColor(int weight, String color) {
        if (this.weight < weight) {
            this.color = color;
        }
        components.forEach(c -> c.changeColor(weight, color));
    }

    public void addComponent(Component component) {
        components.add(component);
    }


    @Override
    public int compareTo(Component o) {
        return Comparator.comparing(Component::getWeight)
                .thenComparing(Component::getColor)
                .compare(this, o);
    }


    public String toString(String indent) {
        String nested = components.stream()
                .map(c -> c.toString(indent + "---"))
                .collect(Collectors.joining("\n"));

        String result = String.format("%s%d:%s", indent, weight, color);

        if (!nested.isEmpty()) {
            result += "\n" + nested;
        }
        return result;
    }

    @Override
    public String toString() {
        return toString("");
    }
}
