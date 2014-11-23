/**
 * 
 */
package exceptions;

/**
 * @author Valy
 *
 */
public class InputException extends Exception {

    /**
     * The constructor for the input exception
     * @param input The input on witch the exception was obtained
     * @param errorMessage  The default exception message
     */
    public InputException(String errorMessage) {
        super(errorMessage);
    }
}
