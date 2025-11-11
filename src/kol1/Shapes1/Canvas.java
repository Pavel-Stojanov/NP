package kol1.Shapes1;

import java.util.List;

public class Canvas {
    private String id;
    private List<Integer> sqares;

    public Canvas(String id, List<Integer> sqares) {
        this.id = id;
        this.sqares = sqares;
    }

    public int getCount(){
        return sqares.size();
    }

    public int getPerimeter(){
        return sqares.stream().mapToInt(i->i*4).sum();
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",id,getCount(),getPerimeter());
    }
}
