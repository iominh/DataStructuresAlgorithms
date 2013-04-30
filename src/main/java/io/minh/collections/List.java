/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.minh.collections;

/**
 * An ordered collection allowing duplicates.
 *
 * @author mtnguyen
 */
public interface List<T> {

    /**
     * Appends the specified element to the end of this list
     *
     * @param element
     * @return true if this collection changed as a result of the call
     */
    boolean add(T element);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     */
    T get(int index) throws IndexOutOfBoundsException;
}
