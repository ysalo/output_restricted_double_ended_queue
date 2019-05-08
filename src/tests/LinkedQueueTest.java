/*
 * TCSS 342 - Winter 2017
 * Assignment 2
 */

package tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import structures.LinkedQueue;

/**
 * Test the LinkedQueue class methods.
 * 
 * @author Yaro Salo
 * @version 1.1
 */
public class LinkedQueueTest {

    /**The data structure to be tested. */
    private LinkedQueue<Integer> myQueue;
    
    /** 
     * Initialize the test fixture before each test.
     */
    @Before
    public void setUp() {
        myQueue = new LinkedQueue<>();   
       
    }
    
    /**
     * Test the default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull("myQueue was not initialized!", myQueue);
        assertEquals("myQueue shoule have a size of 0!", 0, myQueue.size());
        assertTrue("myQueue should be empty!", myQueue.isEmpty());
    }

    
    /**
     * Test dequeue() method with an empty structure.
     */
    @Test (expected = NoSuchElementException.class) 
    public void testDequeueEmpty() {
        
        myQueue.dequeue();
    }
    
    /**
     * Test the peek() with an empty structure.
     */
    @Test (expected = NoSuchElementException.class) 
    public void testPeekEmpty() {
        
        myQueue.peek();
    }
    
    /**
     * Test the enqueue() method.
     */
    @Test
    public void testEnqueue() {
        for (int i = 0; i <= 10; i++) {
            myQueue.enqueue(i);
            
            assertEquals("enque() failed to update the size of the structure.",
                         i + 1, myQueue.size());  
            assertEquals("enque() failed when adding elements", 
                         0, (int) myQueue.peek());

            
        }
        assertEquals("toString() returns an unexpected data",
                     "front==>[0,1,2,3,4,5,6,7,8,9,10]", myQueue.toString());
       
    }
                  
    /**
     * Test the dequeue() method.
     */
    @Test
    public void testDequeue() {
        for (int i = 0; i <= 10; i++) {
            
            myQueue.enqueue(i);
        }
        
        for (int i = 0; i <= 10; i++) {
            
            assertEquals("dequeue() returned an unexprected result",
                         i, (int) myQueue.dequeue());
            assertEquals("dequeue() failed to update the size of the the queue",
                         10 - i, myQueue.size());
            
        }

        assertEquals("dequeue() failed to update the size of the the queue",
                     0, myQueue.size());
    }

    /**
     * Test the peek() method.
     */
    @Test
    public void testPeek() {
        for (int i = 0; i <= 10; i++) {
            
            myQueue.enqueue(i);
            assertEquals("peek() returns inncorrect value", 0, (int) myQueue.peek());
        }

    }

    /**
     * Test the isEmpty() method.
     */
    @Test
    public void testIsEmptyNotFalse() {
        myQueue.enqueue(1);
        assertFalse(myQueue.isEmpty());
    }
    
    /**
     * Test toString() empty.
     */
    @Test 
    public void testToStringEmpty() {
        
        assertEquals("toString() should return an empty string", "Empty", myQueue.toString());
    }
    
    /**
     * Test toString() with one element.
     */
    @Test
    public void testToStringOneElement() {
        
        myQueue.enqueue(1);
        assertEquals("toString returned unexpected result" , "front==>[1]",
                     myQueue.toString());
    }
    
    /**
     * Test the toString() method.
     */
    @Test
    public void testToString() {
       
        for (int i = 0; i <= 10; i++) {
           
            myQueue.enqueue(i);    
        }

        assertEquals("toString() returns an unexpected data", 
                     "front==>[0,1,2,3,4,5,6,7,8,9,10]", myQueue.toString());
        
    }
}    
