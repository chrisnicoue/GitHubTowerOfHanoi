// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
// -- Chris Nicoue Beglah (chrisn04)
/**
 * 
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * 
 * This class is a test calss for the linked stack class
 * and all of its methdos
 * @author Chris Nicoue Beglah (chrisn04)
 * @version 2023.10.17
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<String> stack;

    /**
     * 
     */
    public LinkedStackTest() {
        // this is usually blank
    }


    /**
     * Initializes the stack fields
     */
    public void setUp() {
        stack = new LinkedStack<>();

    }


    /**
     * test clear method
     * to make sure there is nothing left on the
     * stack after it is called
     * 
     */
    public void testClear() {

        stack.push("Open");
        stack.push("Close");
        stack.push("Blue");
        stack.clear();

        assertEquals(0, stack.size());

    }


    /**
     * Test the push method to make sure
     * a disk is being pushed
     */
    public void testPush() {
        stack.push("Big");
        assertEquals(1, stack.size());

    }


    /**
     * test the is empty method when
     * it should return false and when it
     * should return true
     */
    public void testEmpty() {
        stack.push("Open");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());

    }


    /**
     * test the peek method to make sure
     * it throws the correct exception when the stack is empty
     * 
     */
    public void testEmptyPeek() {
        Exception thrown = null;
        try {
            stack.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * Test the pop method to make sure it returns an exception when
     * the stack is empty
     * 
     */
    public void testEmptyPop() {

        Exception thrown = null;
        try {
            stack.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);

    }


    /**
     * Makes sure the pop methods removes
     * the first object from the stack
     */
    public void testPop() {
        stack.push("Open");
        stack.push("Close");
        stack.push("Blue");
        assertEquals("Blue", stack.pop());
        assertEquals(2, stack.size());

    }


    /**
     * test the peek method to make sure
     * it returns the right data value at the top of
     * the stack
     */
    public void testPeek() {
        stack.push("Open");
        stack.push("Close");
        stack.push("Blue");
        assertEquals("Blue", stack.peek());

    }


    /**
     * test the too string method to make sure it
     * return the correct string in the correct order
     */
    public void testToString() {
        stack.push("Open");
        stack.push("Close");
        stack.push("Blue");
        String excpedted = ("[Blue, Close, Open]");
       
        assertEquals(excpedted, stack.toString());

    }

}
