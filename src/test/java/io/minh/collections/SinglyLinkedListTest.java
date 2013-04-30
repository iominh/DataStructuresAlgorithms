package io.minh.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for SinglyLinkedList.
 */
public class SinglyLinkedListTest {

    @Before
    public void setup() {
    }

    @Test
    public void testAdd_success_list_12_contains_1() {
        try {
            List<String> list = new SinglyLinkedList<String>("1");
            list.add("2");
            assertTrue("test list [1,2] contains [2]", list.get(1) != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }
}
