
package Time;

/**
 * A class that reports bad input data.
 * @author Paola Jiron
 */

public class TimeException extends Exception
{
    /**
     * Constructs a no argument time exception object.
     */
    public TimeException()
    {
        
    }
    /**
     * Constructs a time exception object with a string parameter that is then 
     * up-casted to inherit the exception messages from super class Exception.
     */
    public TimeException(String message)
    {
        super(message);
    }
}
