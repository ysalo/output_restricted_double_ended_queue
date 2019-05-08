/*
 * TCSS 342
 */

package structures;

/**
 * Defines operations for a FIFO queue.
 * 
 * @author Alan Fowler
 * @version 1.1
 * 
 * @param <E>
 */
public interface QueueADT<E> {
    
    /*
     * FYI.
     * The JCF has the Queue interface which defines the following methods:
     * 
     * Instead of enqueue() there are methods add() which can throw an exception
     * and offer() which returns false when adding is not possible (on capacity limited queues)
     * 
     * Instead of dequeue() there are methods remove() which throws an exception when called
     * on an empty queue and poll() which returns null when called on an empty queue
     * 
     * There are also methods to inspect (but not remove) the element at the head of the queue.
     * These are element() which can throw an exception and peek().
     * 
     * The Deque interface (double ended queue) adds the ability to add and remove elements
     * from either end of the queue.
     * 
     * To insert: addFirst(), offerFirst(), addLast(), offerLast()
     * To remove: removeFirst(), pollFirst(), removeLast(), pollLast()
     * To inspect: getFirst(), peekFirst(), getLast(), peekLast() 
     */
    
    /**
     * Adds the specified element to the 'rear' or 'tail' of the queue.
     * 
     * @param theElement the element to add to the queue
     */
    void enqueue(E theElement);

    // This is both a query and a command!
    // Maybe we should implement 'remove()' instead?
    /**
     * Removes and returns the 'front' or 'head' element from the queue.
     * (Remove and return the least recently added element from the queue.)
     * 
     * @return the front element from the queue
     */
    E dequeue();

    /**
     * Returns the 'front' or 'head' element from the queue (without removing
     * the element).
     * 
     * @return the front element from the queue
     */
    E peek();

    /**
     * How many elements are in the queue?
     * 
     * @return the count of elements currently in the queue
     */
    int size();
    
    /**
     * Is the queue empty?
     * 
     * @return True if the queue contains no elements; false otherwise
     */
    boolean isEmpty();

}
