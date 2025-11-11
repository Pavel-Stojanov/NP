package kol1.Canvas6;

abstract class Shape implements Scalable, Stackable{
    private String id;
    private Color color;

    public Shape(String id, Color color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%s: %-5s %10s %10.2f",
                getType(),
                id,
                color.toString(),
                weight());
    }
}
