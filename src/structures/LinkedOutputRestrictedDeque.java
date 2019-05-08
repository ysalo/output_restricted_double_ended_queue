/*
 * TCSS 342 - Winter 2017
 * Assignment 2
 */

package structures;

/**
 * 
 * 
 * @author Yaro Salo
 * @version 1.1
 *
 * @param <E>
 */
public class LinkedOutputRestrictedDeque<E> extends LinkedQueue<E>
                implements OutputRestrictedDequeADT<E> {

    /**
     * Constructs a new class using the parent constructor.
     */
    public LinkedOutputRestrictedDeque() {
        super();
    }
  
    @Override
    public void enqueueAtFront(final E theElement) {
        
        final Node<E> frontNode = new Node<E>(theElement, getFront());
        setFront(frontNode);
        
        if (isEmpty()) {
            setRear(frontNode);
        }
        incrementSize();  
    }      
}
