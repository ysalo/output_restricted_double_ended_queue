/*
 * TCSS 342 - Winter 2017
 * Assignment 2
 */

package applications;


import structures.LinkedOutputRestrictedDeque;

/**
 * An implementation of the Radix Sort using a LinkedOutputRestrictedDeque.
 * 
 * @author Yaro Salo
 * @version 1.2
 *
 */
public final class RadixSort {

    /** Possible digits range. */
    private static final int DIGITS = 10;
    
    /** Modulo to use to get the currently desired significant digit. */
    private static final int MOD = 10;
    
    /**
     * Private constructor to prevent instantiation. 
     */
    private RadixSort() {
        
        //Utility classes should not be instantiated. 
        throw new AssertionError("Utility class instantiation.");  
    }
    
    /**
     * Sorts a given deque of integers from smallest to largest.
     * 
     * @param theDeque is the dequeue of integers to be sorted.
     * @return a sorted deque in order from smallest to largest.
     */
    public static LinkedOutputRestrictedDeque<Integer> 
                  radixSort(final LinkedOutputRestrictedDeque<Integer> theDeque) {

        //The number of times needed to run the sorting algorithm based on the 
        //number with the most digits.
        int maxDigits = 0;
        
        int significantPlace = 1;
       
        final LinkedOutputRestrictedDeque<Integer> masterQueue = new 
                        LinkedOutputRestrictedDeque<>();
        
        //digit buckets
        final LinkedOutputRestrictedDeque<Integer>[] buckets
            = new LinkedOutputRestrictedDeque[DIGITS];
        
        for (int i = 0; i < DIGITS; i++) {     
            buckets[i] = new LinkedOutputRestrictedDeque<Integer>();   
        }
       
        //enqueue the numbers from the original deque to the master 
        //and find the the max number of digits.
        while (!theDeque.isEmpty()) { 
            final int tempNum = theDeque.dequeue();
            masterQueue.enqueue(tempNum);
            
            //Get the number of digits of the number. 
            final int digits = String.valueOf(tempNum).length();
            if (maxDigits < digits) maxDigits = digits;
        }

        for (int i = 0; i < maxDigits; i++) {

            //Fill the buckets based on the currently significant digit.
            while (!masterQueue.isEmpty()) {
                final int number = masterQueue.dequeue();
                final int tempNum = number / significantPlace;
                //Put the number into a queue corresponding to the current digit.
                buckets[tempNum % MOD].enqueue(number);
            }
            //Empty the buckets back into the master dequeue sorted based on the 
            //current digit. 
            for (int j = 0; j < DIGITS; j++) {
                while (!buckets[j].isEmpty()) {
                    masterQueue.enqueue(buckets[j].dequeue());
                }
            }
            //advance significant digit.
            significantPlace *= DIGITS;    
        }
        return masterQueue; 
    }
}
