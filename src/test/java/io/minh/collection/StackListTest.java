package io.minh.collection;

import io.minh.collection.stack.StackList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for SinglyLinkedList.
 */
public class StackListTest {

    private StackList<String> list11;
    private StackList<String> emptyStack;

    @Before
    public void setup() {
        emptyStack = new StackList<String>();
    }

    /**
     * Remove the head of the list and verify that it's removed correctly.
     */
    @Test
    public void testEmpty() {
        assertTrue("stack == [" + emptyStack.toString() + "] and should == null", emptyStack.empty());
    }
}
