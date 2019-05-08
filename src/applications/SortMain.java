/*
 * TCSS 342 - Winter 2017
 * Assignment 2
 */

package applications;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import structures.LinkedOutputRestrictedDeque;

/**
 * Runs the radix sort application.
 * 
 * @author Yaro Salo
 * @version 1.1
 *
 */
public final class SortMain {

    /**
     * Private constructor to prevent instantiation. 
     */
    private SortMain() {
        
        //Utility classes should not be instantiated. 
        throw new AssertionError("Utility class instantiation.");
    }
    
    /**
     * Starting point for this application.
     * 
     * @param theArgs command line parameter, ignored in this application.
     * @throws FileNotFoundException if a file could not be found.
     */
    public static void main(final String[] theArgs) throws FileNotFoundException {
      
        
        
        LinkedOutputRestrictedDeque<Integer> deque = 
                        new LinkedOutputRestrictedDeque<>();
        displayMessage();
        //FileReaderWriter.writeRandom(100,  20); //writes random integers to a file.
        deque = FileReaderWriter.readFileToDeque(deque);
        deque = RadixSort.radixSort(deque);
        FileReaderWriter.writeFile(deque);
    }
    
    /**
     * Displays a message about this program.
     */
    public static void displayMessage() {
    
        JOptionPane.showMessageDialog(null, "This program sorts a file of unsorted integers "
                        + "using an implementation \nof the radix sort algorithm. \n"
                        + "You will be asked to open a file of unsorted integers. \n"
                        + "The file should be formatted in such a way that a single "
                        + "integer appears \non a single line. \n" 
                        + "Once the algorithm is finished you will be asked to choose a "
                        + "name of the \nfile to which you would like the sorted result to be"
                        + " written to.");
                        
    }

}
