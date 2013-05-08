/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.minh.collection.stack;

import io.minh.collection.list.SinglyLinkedList;

/**
 * Standard Stack data structure for FIFO (first-in-first-out) operations. Uses
 * a linked list internally.
 *
 * @author mtnguyen
 */
public class StackList<E> implements Stack {

    SinglyLinkedList top = null;

    @Override
    public boolean empty() {
        return top.isEmpty();
    }

    @Override
    public Object peek() {
        return top;
    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object push(Object item) {
        SinglyLinkedList newItem = new SinglyLinkedList(item);
        if (top == null) {
            top = newItem;
        } else {
            SinglyLinkedList last = top.getLast();
            last.setNext(newItem);
        }
        return newItem;
    }

    @Override
    public int search(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        if (top != null) {
            return top.toString();
        } else {
            return "[]";
        }
    }
}
