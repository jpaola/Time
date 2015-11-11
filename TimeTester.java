package Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A test class for the Time class that analyzes input read from a file. Data 
 * read from a file take attributes of time of day in military format. This 
 * class will throw exceptions for particular data and also uses an exception
 * handler that implements the superclass Exception ( for checked exceptions).
 * If an exception is thrown, a message will be displayed on the output screen
 * including the reason why it has been thrown.
 */

/**
 *
 * @author Paola Jiron
 */

public class TimeTester
{
    public static void main(String[] args)
    {
       Scanner in = new Scanner (System.in);    // monitor user input
       
       boolean found = false;       // flag that will be set when file is found
       
       while (!found)       // evaluate user input for existing file
       {
            try  // read and analyze user input...
            {
                System.out.println("\nPlease enter a file name: ");
                
                String theFile = in.next();    

                // read the file
                
                Scanner fileReader = new Scanner(new File(theFile));
                
                while (fileReader.hasNextLine())    // while not eof
                {
                    String line = fileReader.nextLine();    // read each line
                    
                    // extract each token
                    
                    Scanner lineReader = new Scanner(line);
                    
                    try   
                        // evaluate for exceptions
                    {
                        int hour =  lineReader.nextInt();   // extract hr...
                        
                        int minutes = lineReader.nextInt();  // ... mins...
                        
                        int seconds = lineReader.nextInt();  //...and seconds
                        
                        // create a time obj
                        
                        Time time = new Time (hour, minutes, seconds);
                        
                        // display the time
                        
                        System.err.println("\n" + time);
                    }
                    catch(TimeException e)
                    {
                        // display exception msg
                        
                        System.err.println(e.getMessage()); 
                    }
                    catch(NumberFormatException e)  // format exception
                    {
                        System.err.println("Format exception: Type mismatch");
                    }
                    catch(InputMismatchException e)
                    {
                        // display the exception
                        
                        System.err.println("\n" + line 
                             + "\nException: Input mismatch");                 
                    }
                }     
               found = true;            // set flag when file exists
            }    
        
        catch(FileNotFoundException e)  // does the file exist?
        {
            // if it does not, display the following message
            
            System.err.println("Exception: File not found.");
            
            in.nextLine();      // keep monitoring for user input
           
        }
        catch(Exception e)  // handle other exceptions
        {
            System.err.println("\n" + e.getMessage()); // display the exception
        }
             
       }
    }     
} 
