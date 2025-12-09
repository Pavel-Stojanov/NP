package vezbi.Shapes1;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShapesApplication {
    private final List<Canvas> canvases;

    public ShapesApplication() {
        canvases = new ArrayList<>();
    }

    public int readCanvases(InputStream in) {
        Scanner sc = new Scanner(in);
        int n = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String [] parts = line.split("\\s+");
            String id = parts[0];
            List<Integer> squares = new ArrayList<>();
            for (int i = 1; i < parts.length; i++) {
                squares.add(Integer.parseInt(parts[i]));
            }
            canvases.add(new Canvas(id,squares));
            n+=squares.size();
        }
        return n;
    }

    public void printLargestCanvasTo(PrintStream out) {
        PrintWriter writer = new PrintWriter(out);
        canvases.stream()
                .max(Comparator.comparingInt(Canvas::getPerimeter)).ifPresent(writer::println);
        writer.flush();
    }
}
