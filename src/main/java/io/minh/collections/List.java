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
     * Removes the first occurrence of the specified element from this list, if
     * it is present (optional operation). If this list does not contain the
     * element, it is unchanged. More formally, removes the element with the
     * lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if
     * such an element exists). Returns true if this list contained the
     * specified element (or equivalently, if this list changed as a result of
     * the call).
     *
     * @param element
     * @return
     */
    boolean remove(T element);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the number of elements in this list. If this list contains more
     * than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return
     */
    int size();
}
