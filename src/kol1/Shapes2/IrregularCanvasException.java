package kol1.Shapes2;

public class IrregularCanvasException extends RuntimeException {
    private final String id;
    public IrregularCanvasException(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
      return String.format("Canvas %s has a shape with area larger than 10000.00",id);

    }
}
