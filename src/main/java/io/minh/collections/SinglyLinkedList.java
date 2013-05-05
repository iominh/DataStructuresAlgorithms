package io.minh.collections;

/**
 * A singly linked list.
 *
 */
public class SinglyLinkedList<T> implements List {
    
    private SinglyLinkedList<T> next = null;
    private T data = null;
    
    public SinglyLinkedList(T data) {
        this.data = data;
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
    
    public T get(int index) throws IndexOutOfBoundsException {
        T data = null;
        
        int x;
        SinglyLinkedList<T> current = this;
        for (x = 0; x < index; x++) {
            current = current.getNext();
        }
        if (x == index) {
            data = current.getData();
        } else if (x < index) {
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
}
