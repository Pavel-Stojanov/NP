package vezbi.Canvas6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ShapesTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Canvas canvas = new Canvas();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int type = Integer.parseInt(parts[0]);
            String id = parts[1];
            if (type == 1) {
                Color color = Color.valueOf(parts[2]);
                float radius = Float.parseFloat(parts[3]);
                canvas.add(id, color, radius);
            } else if (type == 2) {
                Color color = Color.valueOf(parts[2]);
                float width = Float.parseFloat(parts[3]);
                float height = Float.parseFloat(parts[4]);
                canvas.add(id, color, width, height);
            } else if (type == 3) {
                float scaleFactor = Float.parseFloat(parts[2]);
                System.out.println("ORIGNAL:");
                System.out.print(canvas);
                canvas.scale(id, scaleFactor);
                System.out.printf("AFTER SCALING: %s %.2f\n", id, scaleFactor);
                System.out.print(canvas);
            }

        }
    }
}
enum Color {
    RED, GREEN, BLUE
}

class Canvas {
    private List<Shape> shapes;

    public Canvas() {
        shapes = new ArrayList<>();
    }

    private void addShape(Shape shape){
        float nw = shape.weight();
        for (int i = 0; i < shapes.size(); i++) {
            if (nw>shapes.get(i).weight()){
                shapes.add(i, shape);
                return;
            }
        }
        shapes.add(shape);
    }

    public void add(String id, Color color, float radius) {
        Circle circle = new Circle(id,color,radius);
        addShape(circle);
    }

    public void add(String id, Color color, float width, float height) {
        Rectangle rectangle = new Rectangle(id,color,width,height);
        addShape(rectangle);
    }

    public void scale(String id, float scaleFactor) {
        Shape scaled = null;
        int idx = 0;
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).getId().equals(id)) {
                scaled = shapes.get(i);
                idx = i;
                break;
            }
        }
        if (scaled != null) {
            shapes.remove(idx);
            scaled.scale(scaleFactor);
            addShape(scaled);
        }
    }

    @Override
    public String toString() {
        return shapes.stream()
                .map(Shape::toString)
                .collect(Collectors.joining("\n"))+"\n";
    }
}