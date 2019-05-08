/*
 * TCSS 342 - Winter 2017
 * Assignment 2
 */

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structures.LinkedOutputRestrictedDeque;

/**
 * Tests the LinkedOutputRestrictedDeque class.
 * 
 * @author Yaro Salo
 * @version 1.1 
 */
public class LinkedOutputRestrictedDequeTest {
    
    //Test fixture 
   
    /** The data structure to be tested. */
    private LinkedOutputRestrictedDeque<Integer> myStructure;
    
    /**
     * Initialize the test fixture before each test.
     */
    @Before
    public void setUp() {
        
        myStructure = new LinkedOutputRestrictedDeque<>();
    }

    /**
     * Test the testEnqueueAtFront() method with an initially empty structure.
     */
    @Test
    public void testEnqueueAtFrontEmpty() {

        for (int i = 0; i <= 10; i++) {
      
            myStructure.enqueueAtFront(i);
            assertEquals("the size was not update correctly", i + 1, myStructure.size());
            assertEquals("the front element holds unexpected data", 
                         i, (int) myStructure.peek());

        }
        assertEquals("toString() returns an unexpected data", 
                     "front==>[10,9,8,7,6,5,4,3,2,1,0]", myStructure.toString());
    }
    
    /**
     * Test the testEnqueueAtFront() method with an initially empty structure.
     */
    @Test
    public void testEnqueueAtFrontNotEmpty() {
       
        for (int i = 1; i <= 5; i++) { 
            
            myStructure.enqueue(i);    
        }
        
        //Get the current size of the structure before modification.
        final int currentSize = myStructure.size(); 
        for (int i = 1; i <= 5; i++) {
            myStructure.enqueueAtFront(i);
            
            assertEquals("the size was not update correctly",
                         currentSize + i, myStructure.size());
            assertEquals("the front element holds unexpected data", 
                         i, (int) myStructure.peek());
 
        }
        System.out.println(myStructure.toString());
        assertEquals("toString() returns an unexpected data", 
                     "front==>[5,4,3,2,1,1,2,3,4,5]", myStructure.toString());
    }
}
