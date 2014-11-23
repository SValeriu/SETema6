/**
 * 
 */
package interfaces;

import java.awt.event.ActionListener;

/**
 * @author Valy
 *The interface implemented by the controller and made public so that all views can use it
 */
public interface IController extends ActionListener {
    public static final String ACTION_UPDATE = "UPDATE";
}
