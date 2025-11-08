package vezbi.Shapes2;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShapesApplication {
    private double maxArea;
    private List<Canvas> canvases;


    public ShapesApplication(double maxArea) {
        this.maxArea = maxArea;
        canvases = new ArrayList<>();
    }

    public void readCanvases(InputStream in) {
        Scanner sc = new Scanner(in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String id = parts[0];
            try {
                Canvas current = new Canvas(id);
                for (int i = 0; i < parts.length; i += 2) {
                    String type = parts[i];
                    int size = Integer.parseInt(parts[i + 1]);

                    Shape shape;
                    if (type.equals("C")) {
                        shape = new Circle(size);
                    } else {
                        shape = new Square(size);
                    }
                    if (shape.getArea() > maxArea) {
                        throw new IrregularCanvasException(id);
                    }
                    current.addShape(shape, type);
                }
                canvases.add(current);
            } catch (IrregularCanvasException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printCanvases(PrintStream out) {
        PrintWriter writer = new PrintWriter(out);

        canvases.stream()
                .sorted(Comparator.comparing(Canvas::getTotalArea).reversed())
                .forEach(writer::println);

        writer.flush();
    }
}