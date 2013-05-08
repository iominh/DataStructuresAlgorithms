package io.minh.collection;

import io.minh.collection.stack.StackList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for SinglyLinkedList.
 */
public class StackListTest {

    private static StackList<String> emptyStack;

    @Before
    public void setup() {
        emptyStack = new StackList<String>();
    }

    /**
     * Remove the head of the list and verify that it's removed correctly.
     */
//    @Test
    public void testEmpty() {
        assertTrue("stack == [" + emptyStack.toString() + "] and should == []", emptyStack.empty());
    }

    /**
     * Remove the head of the list and verify that it's removed correctly.
     */
    @Test
    public void test_push_item() {
        emptyStack.push("1");
        assertTrue("stack == [" + emptyStack.toString() + "] and should == [1]", !emptyStack.empty());
    }
}
