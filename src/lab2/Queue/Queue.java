package lab2.Queue;

import java.util.LinkedList;

public class Queue<T>{
    private LinkedList<T> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(T t) {
        queue.addLast(t);
    }

    public T dequeue() throws EmptyQueueException {
        if (queue.isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue.removeFirst();
    }

    public T peek() throws EmptyQueueException {
        if (queue.isEmpty()) {
            throw new EmptyQueueException(e);
        }
        return queue.getFirst();
    }

    public T inspect() {


    }

    public int count() {
    }
}
