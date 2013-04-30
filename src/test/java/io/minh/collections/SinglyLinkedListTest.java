package io.minh.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for SinglyLinkedList.
 */
public class SinglyLinkedListTest {

    private List<String> list12;

    @Before
    public void setup() {
        list12 = new SinglyLinkedList<String>("1");
        list12.add("2");
    }

    @Test
    public void testAdd_success_list_12_contains_index1() {
        assertTrue("test list [1,2] contains element at index 1", list12.get(1) != null);
    }

    @Test(expected = Exception.class)
    public void testAdd_expectFailure_list12_contains_index2() {
        assertTrue("test list [1,2] contains element at index 2", list12.get(2) != null);
    }
}
