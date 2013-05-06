package io.minh.collections;

/**
 * A singly linked list. This data structure is purely academic and implements a
 * linked list without using the actual Java implementations.
 *
 */
public class SinglyLinkedList<T> implements List {

    private SinglyLinkedList<T> next = null;
    private T data = null;

    public SinglyLinkedList(T data) {
        this.data = data;
    }

    /**
     * An empty list has null data members
     */
    public SinglyLinkedList() {
    }

    public boolean add(Object element) {
        boolean listChanged = false;
        SinglyLinkedList last = getLast();
        SinglyLinkedList next = new SinglyLinkedList(element);
        last.next = next;
        return listChanged;
    }

    public SinglyLinkedList getLast() {
        SinglyLinkedList last = this;
        while (last.getNext() != null) {
            last = getNext();
        }
        return last;
    }

    public boolean remove(Object element) {
        boolean removed = false;

        SinglyLinkedList current = this, previous = null, next = null;
        while (current != null) {
            next = current.getNext();

            if (current.getData().equals(element)) {
                if (previous != null) {
                    previous.setNext(next);
                }
                if (next != null) {
                    current.setData(next.getData());
                    current.setNext(next.getNext());
                } else {
                    current.setData(null);
                }
                removed = true;
            }
            previous = current;
            current = current.getNext();
        }

        return removed;
    }

    /**
     * Remove duplicates by finding all identical elements after the current
     * node. Runs in O(n^2).
     *
     * @return
     */
    public boolean removeDuplicates() {
        boolean removed = false;

        for (SinglyLinkedList current = this; current != null;
                current = current.getNext()) {

            // remove first occurrence of element in remainder of list
            if (current.remove(current.getData())) {
                removed = true;
            }
        }

        return removed;
    }

    private SinglyLinkedList getList(int index) {
        SinglyLinkedList item = null;

        int x;
        SinglyLinkedList<T> current = this;
        for (x = 0; x < index; x++) {

            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.getNext();
        }

        if (x == index) {
            item = current;
        }
        return item;
    }

    public int size() {
        int size = 0;

        for (SinglyLinkedList current = this; current != null; current = current.getNext()) {
            if (!current.isEmpty()) {
                size++;
            }
        }

        return size;
    }

    public T get(int index) {
        T data = null;
        SinglyLinkedList<T> current = getList(index);
        if (current != null) {
            data = current.getData();
        } else {
            throw new IndexOutOfBoundsException();
        }
        return data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        SinglyLinkedList current = this;
        while (current != null) {
            Object data = current.getData();
            if (data != null) {
                sb.append(data.toString());
            }
            current = current.getNext();
        }
        return sb.toString();
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

    public boolean isEmpty() {
        return next == null && data == null;
    }
}
