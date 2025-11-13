package kol1.Component14;

public class InvalidPositionException extends Exception {
    public InvalidPositionException(int pos) {
        super(String.format("Invalid position %d, alredy taken!", pos));
    }
}