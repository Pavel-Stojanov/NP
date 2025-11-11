package kol1.Shapes2;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Canvas {
    private String id;
    private List<Shape> shapes;
    private List<String> types;

    public Canvas(String id) {
        this.id = id;
        shapes = new ArrayList<>();
        types = new ArrayList<>();
    }

    public void addShape(Shape shape, String type) {
        shapes.add(shape);
        types.add(type);
    }

    public double getTotalArea() {
        return shapes.stream()
                .mapToDouble(Shape::getArea)
                .sum();
    }

    public DoubleSummaryStatistics getStats() {
        return shapes.stream()
                .mapToDouble(Shape::getArea)
                .summaryStatistics();
    }

    public int Count() {
        return shapes.size();
    }

    public long Circles() {
        return types.stream().filter(type -> type.equals("C")).count();
    }

    public long Squares() {
        return types.stream().filter(type -> type.equals("S")).count();
    }

    @Override
    public String toString() {
        DoubleSummaryStatistics stats = getStats();
        return String.format("%s %d %d %d %.2f %.2f %.2f",
                id,
                Count(),
                Circles(),
                Squares(),
                stats.getMin(),
                stats.getMax(),
                stats.getAverage()
        );
    }
}
