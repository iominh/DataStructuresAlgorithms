package io.minh.collections;

/**
 * A singly linked list.
 *
 */
public class SinglyLinkedList<T> implements List {

    private SinglyLinkedList next = null;
    private T data = null;

    public SinglyLinkedList(T data) {
        this.data = data;
    }

    public boolean add(Object element) {
        boolean listChanged = false;
        SinglyLinkedList next = new SinglyLinkedList(element);

        if (getNext() == null) {
            this.next = next;
            listChanged = true;
        } else {
            listChanged = next.add(next);
        }
        return listChanged;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        T data = null;

        int x;
        SinglyLinkedList<T> current = this, next = getNext();
        for (x = 1; x < (index - 1); x++) {
            current = next;
            next = current.getNext();
        }
        if (x == index) {
            data = current.getData();
        } else if (x < index) {
            throw new IndexOutOfBoundsException();
        }

        return data;
    }

    public SinglyLinkedList getNext() {
        return next;
    }

    public void setNext(SinglyLinkedList next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
