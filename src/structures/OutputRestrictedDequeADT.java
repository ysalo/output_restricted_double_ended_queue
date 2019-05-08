/*
 * TCSS 342 - Winter 2017
 * Assignment 2
 */

package structures;

/**
 * Defines an additional operation that allows element addition to the front of a queue.
 * 
 * @author Yaro Salo
 * @version 1.1
 *
 * @param <E>
 */
public interface OutputRestrictedDequeADT<E> extends QueueADT<E> {

    /** Allows the ability to add elements to the front of a queue. 
     * 
     * @param theElement the element to be added to the queue.
     */
    void enqueueAtFront(E theElement); 
    
}
