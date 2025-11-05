package lab2.Queue;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Queue is empty!");
    }

}
