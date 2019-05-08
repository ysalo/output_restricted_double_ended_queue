/*
 * TCSS 342 - Winter 2017
 * Assignment 2
 */

package applications;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
//import java.util.Random;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


import structures.LinkedOutputRestrictedDeque;

/**
 * This class give the ability read a file to a deque and  
 * write a deque to a file of the users choosing.
 * 
 * @author Yaro Salo
 * @version 1.1
 *
 */
public final class FileReaderWriter {

    /** File not found string. */
    public static final String NOT_FOUND = "File Not Found!";
    
    /** A JFileChooser to open and save files. */
    private static final JFileChooser CHOOSER = new JFileChooser(".");
        
    /**
     * Private constructor to prevent instantiation. 
     */
    private FileReaderWriter() {
        
        //Utility classes should not be instantiated. 
        throw new AssertionError("Utility class instantiation.");
    }
 
    
    /**
     * Reads the contents of a file into a deque.
     * 
     * @param theDeque is the deque to read the file into.
     * @return a deque filled with integers from a file.
     * @throws FileNotFoundException if a file cannot be found.
     */
    public static LinkedOutputRestrictedDeque<Integer> 
                readFileToDeque(final LinkedOutputRestrictedDeque<Integer> theDeque)
                throws FileNotFoundException {
        
        JOptionPane.showMessageDialog(null, "Please select a file to sort");
        final int result = CHOOSER.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            
            try {
                final File file = CHOOSER.getSelectedFile();
                final Scanner scanner = new Scanner(file);
                while (scanner.hasNextInt()) {
    
                    theDeque.enqueue(scanner.nextInt()); 
                }
                scanner.close();
                
            } catch (final IOException e) {
                
                JOptionPane.showMessageDialog(null, NOT_FOUND);
            }
        }
      
        return theDeque;
    }
      
    /**
     * Writes the contents of a deque to a file of the users choosing.
     * 
     * @param theDeque is the deque to write from 
     */
    public static void writeFile(final LinkedOutputRestrictedDeque<Integer> theDeque) {
        JOptionPane.showMessageDialog(null, "Choose file to save to");
        CHOOSER.setDialogTitle("Save file");   
         
        final int userSelection = CHOOSER.showSaveDialog(null);
         
        if (userSelection == JFileChooser.APPROVE_OPTION) {
           
            final String file = CHOOSER.getSelectedFile().getAbsolutePath();
        
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))) {
                
                while (!theDeque.isEmpty()) {
                    writer.write(theDeque.dequeue() + "\n");
                }
            } catch (final IOException e) {
                
                JOptionPane.showMessageDialog(null, NOT_FOUND);   
            }
        }
        
    }
    
    /**
     * Writes random integers to a file. 
     * @param theHowMany how many numbers to write to a file.
     * @param theMax is the largest any random number can be (inclusive).
     */
    public static void writeRandom(final int theHowMany, final int theMax) {
        JOptionPane.showMessageDialog(null, "Choose where to write random"); 
        final Random rand = new Random();    
        CHOOSER.setDialogTitle("Save file");   
        
        final int userSelection = CHOOSER.showSaveDialog(null);
         
        if (userSelection == JFileChooser.APPROVE_OPTION) {
           
            final String file = CHOOSER.getSelectedFile().getAbsolutePath();
        
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))) {
                
                for (int i = 0; i < theHowMany; i++) {
                    writer.write(rand.nextInt(theMax + 1) + "\n");
                }
                JOptionPane.showMessageDialog(null, "Finished Writing Random.");  
            } catch (final IOException e) {
                
                JOptionPane.showMessageDialog(null, NOT_FOUND);   
            }
        }
    }
    
}
