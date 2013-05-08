/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.minh.collection.stack;

/**
 * Standard Stack data structure for FIFO (first-in-first-out) operations. Uses
 * a linked list internally.
 *
 * @author mtnguyen
 */
public class StackList<E> implements Stack {
    
    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public Object peek() {
        return null;

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object push(Object item) {
        return null;
    }

    @Override
    public int search(Object o) {
        return 0;
    }
    
    @Override
    public String toString() {
        return "stack";
    }
}
