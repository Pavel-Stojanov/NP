package lab2.Arrays;

import java.util.Arrays;

public class ResizableArray<T> {
    private T[] elements;
    int size;

    @SuppressWarnings("unchecked")
    public ResizableArray() {
        elements = (T[]) new Object[10];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void shrinkIfNeeded() {
        if (size <= elements.length / 4 && elements.length > 10) {
            int newCapacity = elements.length / 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void addElement(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public boolean removeElement(T element) {
        int index = indexOf(element);

        if (index == -1) {
            return false;
        }
        int move = size - index - 1;
        if (move > 0) {
            System.arraycopy(elements, index + 1, elements, index, move);
        }
        elements[size--] = null;
        shrinkIfNeeded();
        return true;

    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public Object[] toArray(){
        Object[] resultArray = new Object[size];
        System.arraycopy(elements, 0, resultArray, 0, size);
        return resultArray;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int count() {
        return size;
    }

    public T elementAt(int idx){
        if (idx < 0 || idx > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        return elements[idx];
    }

    public static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src) {
        int srcSize = src.size;
        for (int i = 0; i < srcSize; i++) {
            dest.addElement(src.elementAt(i));
        }
    }
}
