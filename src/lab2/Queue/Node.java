package lab2.Queue;

public class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public Node<T> getNext(Node<T> next) {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
