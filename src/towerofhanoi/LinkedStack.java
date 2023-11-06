// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the
// actions of those who do.
// -- Chris Nicoue Beglah (chrisn04)
/**
 * 
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * /**
 * 
 * This class implements a the stack interface
 * 
 * @author Chris Nicoue Beglah (chrisn04)
 * @version 2023.10.17
 * @param <T> is Generic placeholder
 */
public class LinkedStack<T> implements StackInterface<T> {
    private int size;
    private Node topNode;

    /**
     * This is the constructor for this class
     * and it initializes the fields
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * Turns the stack into a string
     * @return return the names of the stacks 
     * in string form
     * 
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node currentNode = topNode;
        while (currentNode != null) {
            builder.append(currentNode.getData().toString());
            currentNode = currentNode.getNextNode();

            if (currentNode != null) {

                builder.append(", ");
            }
        }
        return builder + ("]");

    }


    /**
     * Clears the entire stack
     */
    @SuppressWarnings("null")
    @Override
    public void clear() {
        topNode = null;
        size = 0;

    }


    /**
     * Return True when size is 0;
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns that data of the
     * thing thats at the top of the stack
     * 
     * @exception EmptyStackException
     *                throws this exception
     *                when the stack is empty
     * 
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.data;
    }


    /**
     * Removed the node at the top of the stack
     * 
     * @exception EmptyStackException
     *                throws this exception
     *                when the stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T removed = topNode.getData();
        topNode = topNode.next;
        size--;
        return removed;

    }


    /**
     * Pushed new nodes to the stack
     */
    @Override
    public void push(T anEntry) {
        Node newNode = new Node(anEntry, topNode);
        topNode = newNode;
        size++;

    }


    /**
     * Keeps track of what was added and removed from
     * the stack
     * 
     * @return return and integer of the number of
     *         nodes on the stack
     */
    public int size() {
        return size;

    }

    /**
     * A private node class that Linked stack implements
     * they are also singly linked
     */
    private class Node {
        private T data;
        private Node next;

        /**
         * This is the constructor for the class
         * and it initializes the fields
         * 
         * @param entry
         *            takes an enrty
         * @param node
         *            takes a nod and sets it as next
         */
        public Node(T entry, Node node) {
            this(entry);
            this.setNextNode(node);
        }


        /**
         * Another constructor the initializes the data field
         * Returns the data if the node
         * 
         * @param data
         *            sets the data value
         */
        public Node(T data) {
            this.data = data;
        }


        /**
         * Sets the next node of the node that calls it
         * 
         * @param node
         *            takes in a newNode that will be set as
         *            next
         */
        public void setNextNode(Node node) {

            next = node;

        }


        /**
         * Returns the next node
         * @return@ return the next node of the
         * node that called it
         */
        public Node getNextNode() {
            return next;

        }


        /**
         * returns the data of a node
         * 
         * @return the data of the node that called it
         */
        private T getData() {

            return data;
        }

    }

}
