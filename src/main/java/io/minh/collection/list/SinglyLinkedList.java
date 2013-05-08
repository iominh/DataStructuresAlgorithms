package io.minh.collection.list;

import io.minh.collection.list.List;

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
    
    @Override
    public boolean add(Object element) {
        boolean listChanged = false;
        SinglyLinkedList last = getLast();
        SinglyLinkedList currentNext = new SinglyLinkedList(element);
        last.next = currentNext;
        return listChanged;
    }
    
    public SinglyLinkedList getLast() {
        SinglyLinkedList last = this;
        while (last.getNext() != null) {
            last = getNext();
        }
        return last;
    }

    /**
     * Return the kth to last element in the list. For instance, if the list
     * contains 3 elements [1, 2, 3] then
     *
     * <ul>
     *
     * <li>k=0 returns 3</li>
     *
     * <li>k=1 returns 2</li>
     *
     * <li>k=2 returns 1</li>
     *
     * <li>k=3 throws IndexOutOfBoundsException</li>
     *
     * </ul>
     *
     * @param k
     * @return
     */
    public SinglyLinkedList getKthToLast(int k) throws IndexOutOfBoundsException {
        int size = size();
        int position = size - k - 1;
        return getList(position);
    }
    
    @Override
    public boolean remove(Object element) {
        boolean removed = false;
        
        SinglyLinkedList current = this, previous = null, currentNext = null;
        while (current != null) {
            currentNext = current.getNext();
            
            if (current.getData().equals(element)) {
                if (previous != null) {
                    previous.setNext(currentNext);
                }
                if (currentNext != null) {
                    current.setData(currentNext.getData());
                    current.setNext(currentNext.getNext());
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

    /**
     * Remove a node given access only to that node by copying subsequent nodes
     * into the node's position.
     *
     * @param node
     * @return
     */
    public boolean removeNode(SinglyLinkedList node) {
        boolean deleted = false;
        
        if (node != null) {
            SinglyLinkedList next = node.getNext();
            
            if (next != null) {
                node.setNext(next.getNext());
                node.setData(next.getData());
            } else {
                node.setData(null);
                node.setNext(null);
            }
        }
        
        return deleted;
    }
    
    private SinglyLinkedList getList(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
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
    
    @Override
    public int size() {
        int size = 0;
        
        for (SinglyLinkedList current = this; current != null; current = current.getNext()) {
            if (!current.isEmpty()) {
                size++;
            }
        }
        
        return size;
    }
    
    @Override
    public T get(int index) {
        T currentData = null;
        SinglyLinkedList<T> current = getList(index);
        if (current != null) {
            currentData = current.getData();
        } else {
            throw new IndexOutOfBoundsException();
        }
        return currentData;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        SinglyLinkedList current = this;
        while (current != null) {
            Object currentData = current.getData();
            if (currentData != null) {
                sb.append(currentData.toString());
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
