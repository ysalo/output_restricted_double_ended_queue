/*
 * TCSS 342
 */

package structures;

import java.util.NoSuchElementException;


/**
 * A singly-linked implementation of the QueueADT.
 * 
 * @author Alan Fowler
 * @version 1.1
 *
 * @param <E>
 */
public class LinkedQueue<E> implements QueueADT<E> {
    
    /**
     * The number of elements contained in the queue.
     */
    private int mySize;
    
    /**
     * A reference to the first node in the queue.
     * (The 'head' of the queue.)
     */
    private Node<E> myFront;
    
    /**
     * A reference to the last node in the queue.
     * (The 'tail' of the queue.)
     */
    private Node<E> myRear;
    
    /**
     * Initialize an empty queue.
     */
    public LinkedQueue() {
        mySize = 0;
    }
    
    @Override
    public void enqueue(final E theElement) {
        if (mySize == 0) { // Make a queue of one element
            myFront = new Node<E>(theElement);
            
            myRear = myFront;
        } else { // Regular case
            
            myRear.myNext = new Node<E>(theElement);
            myRear = myRear.myNext;
        }
        mySize++;
    }

    
    @Override
    public E dequeue() {
        if (mySize == 0) {
            throw new NoSuchElementException("You can't dequeue from an empty queue!");
        }

        final E returnValue = myFront.myData;
        myFront = myFront.myNext;
        mySize--; //bug fix
        return returnValue;
    }

    @Override
    public E peek() {
        if (mySize == 0) {
            throw new NoSuchElementException("You can't peek in an empty queue!");
        }
        return myFront.myData;
    }

    @Override
    public int size() {
        return mySize;
    }
    
    @Override
    public boolean isEmpty() {
        return mySize == 0;
    }

    /**
     * Quarry command to get the front node.
     * @return the front node.
     */
    public Node<E> getFront() {
        
        return myFront;
    }
    
    /**
     * Quarry command to get the rear node.
     * @return the rear node.
     */
    public Node<E> getRear() {
        
        return myRear;
    }
    
    /**
     * Mutator command to set the front node.
     * 
     * @param theNode is the node to set to.
     */
    protected void setFront(final Node<E> theNode) {
    
        myFront = theNode;
    }
    
    /**
     * Mutator command to set the front node.
     *      
     * @param theNode is the node to set to.
     */
    protected void setRear(final Node<E> theNode) {
        
        myRear = theNode;
    }
    
    /**
     * Mutator command to increment the size.
     */
    protected void incrementSize() {
        
        mySize++;
    }
    
    /**
     * Returns a string representation of the queue and indicates which element is 
     * at the front. Initially returns an empty string.
     */
    @Override
    public String toString() { 
        
        final StringBuilder sb = new StringBuilder();
        
        if (isEmpty()) {
            
            sb.append("Empty");
            
        } else { 
            
            Node<E> tempNode = myFront; //temporary variables as to not modify the state.
            int tempSize = 0;
            sb.append("front==>[");
             
            while (tempSize < mySize) {

                sb.append(tempNode.myData);
                if (tempSize < mySize - 1) {
                    sb.append(',');
                }
                tempNode = tempNode.myNext;
                tempSize++;
            } 
            sb.append(']');
            
        }
        return sb.toString();
    }

    // Inner Node class
    
    /**
     * Represents a node in a singly linked structure.
     * 
     * @author Alan Fowler
     * @version 1.1
     *
     * @param <T>
     */
    public class Node<T> {

        /**
         * A reference to the data element held in this node.
         */
        private T myData;
        
        /**
         * A reference to the next node in the liked structure.
         */
        private Node<T> myNext;
        
        /**
         * Initialize the node using the specified data element.
         * 
         * @param theData the data element held in this node
         */
        Node(final T theData) {
            this(theData, null);
        }
       
        /**
         * Initialize the node using the specified data element and
         * the specified next node.
         * 
         * @param theData the data element held in this node
         * @param theNext the next node in the linked structure
         */
        Node(final T theData, final Node<T> theNext) {
            myData = theData;
            myNext = theNext;
        }
       
    }


}
