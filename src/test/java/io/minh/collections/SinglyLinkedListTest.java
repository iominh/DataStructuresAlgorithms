package io.minh.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for SinglyLinkedList.
 */
public class SinglyLinkedListTest {

    private SinglyLinkedList<String> list11;
    private SinglyLinkedList<String> list123;
    private SinglyLinkedList<String> list12;
    private SinglyLinkedList<String> list1;
    private SinglyLinkedList<String> emptyList;

    @Before
    public void setup() {
        list12 = new SinglyLinkedList<String>("1");
        list12.add("2");

        list1 = new SinglyLinkedList<String>("1");

        list123 = new SinglyLinkedList<String>("1");
        list123.add("2");
        list123.add("3");

        list11 = new SinglyLinkedList<String>("1");
        list11.add("1");

        emptyList = new SinglyLinkedList<String>();
    }

    @Test
    public void testAdd_success_list_12_contains_index1() {
        assertTrue("test list [1,2] contains element at index 1", list12.get(1) != null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd_expectFailure_list12_contains_index2() {
        assertTrue("test list [1,2] contains element at index 2", list1.get(2) != null);
    }

    @Test
    public void test_toString() {
        String str1 = list1.toString();
        String str12 = list12.toString();
        String str123 = list123.toString();

        assertTrue("str1: " + str1, str1.equals("1"));
        assertTrue("str12: " + str12, str12.equals("12"));
        assertTrue("str123: " + str12, str123.equals("123"));
    }

    /**
     * Delete list: [1] -> []
     */
    @Test
    public void testDelete_1() {
        assertTrue("", list1.get(0) != null);
        list1.remove("1");
        assertTrue("list 1 == [" + list1.toString() + "] and should == []", list1.get(0) == null);
    }

    /**
     * Delete 1 from list: [1, 2] -> [2]
     */
    @Test
    public void testDelete_1_from_12() {
        list12.remove("1");
        assertTrue("list 12 == [" + list12.toString() + "] and should == [2]", list12.get(0).equals("2"));
    }

    /**
     * Delete 2 from list: [1, 2] -> [1]
     */
    @Test
    public void testDelete_2_from_12() {
        list12.remove("2");
        assertTrue("list 12 == [" + list12.toString() + "] and should == [1]", list12.get(0).equals("1"));
    }

    /**
     * Delete 2 from list: [1, 2, 3] -> [1, 3]
     */
    @Test
    public void testDelete_2_from_123() {
        list123.remove("2");
        assertTrue("list 123 == [" + list123.toString() + "] and should == [1,3]", list123.get(0).equals("1"));
        assertTrue("", list123.get(1).equals("3"));

    }

    /**
     * Remove duplicates from [1,1] -> [1]
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveDuplicates_from_11() {
        list11.removeDuplicates();
        assertTrue("list 11 == [" + list11.toString() + "] and should == [1]", list11.get(0).equals("1"));
        assertTrue("list 11 == [" + list11.toString() + "] and should == [1]", list11.get(1).equals("1"));
    }

    @Test
    public void testLength() {
        int length0 = emptyList.size();
        int length1 = list1.size();
        int length2 = list12.size();
        int length3 = list123.size();

        assertTrue("empty list size == " + length0 + " and should == 0", length0 == 0);
        assertTrue("list1 size == " + length0 + " and should == 1", length1 == 1);
        assertTrue("list2 size == " + length2 + " and should == 2", length2 == 2);
        assertTrue("list3 size == " + length3 + " and should == 2", length3 == 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testKthToLast() {
        SinglyLinkedList zero = list1.getKthToLast(0);
        SinglyLinkedList first = list1.getKthToLast(1);
        SinglyLinkedList second = list123.getKthToLast(1);


        assertTrue("list 1 0th to last == [" + zero.toString() + "] and should == [1]", zero.toString().equals("1"));
        assertTrue("list 123 1th to last == [" + second.toString() + "] and should == [2]", second.toString().equals("2"));
        assertTrue("list 1 1st to last == [" + first.toString() + "] and should == null", first == null);

    }
}
