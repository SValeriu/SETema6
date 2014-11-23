/**
 * 
 */
package controllers;

import exceptions.InputException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import model.Tema6Model;

import interfaces.IController;
import interfaces.IView;

/**
 * @author Valy
 *
 */
public class Tema6Controller implements IController {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private Tema6Model mModel;

    // The list of views that listen for updates
    private List<IView> mViews;

    /**
     * Constructor
     */
    public Tema6Controller() {
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(ACTION_UPDATE)) {
            // Make the operation
            try {
                JButton source = (JButton) event.getSource();
                if (source != null && source.getAction() != null && source.getAction().getValue(ACTION_UPDATE) != null) {  
                    updateValues();
                } else {
                    notifyViews(true, "Invalid operation data");
                }
            } catch (InputException e) {
                notifyViews(true, e.getMessage());
            } catch (ClassCastException ec) {
                notifyViews(true, ec.getMessage());
            }
        }
    }

    /**
     * Adds a view reference in order to interact with it
     *
     * @param view The view from the controller will receive events and send messages
     */
    public void addView(IView view) {
        if (mViews == null) {
            mViews = new ArrayList<IView>();
        }

        mViews.add(view);
    }

    /**
     * Adds a reference to the model, so it can update it
     *
     * @param model The data model reference
     */
    public void addModel(Tema6Model model) {
        mModel = model;
    }

    /**
     * Notifies the views when an message must be displayed
     *
     * @param isError {@code true} if the message is an error, {@code false} otherwise
     * @param message The string to be displayed
     */
    private void notifyViews(boolean isError, String message) {
        if (mViews != null && !mViews.isEmpty()) {
            for (IView view : mViews) {
                view.onMessage(isError, message);
            }
        }
    }

    /**
     * Updates the temperature and precipitations
     */
    private void updateValues() throws InputException {
        if (mModel != null) {
        	int tempvalue = mModel.getTemperature();
            int precvalue = mModel.getPrecipitation();
            
            try {
                // Update the model
                mModel.setTemperature(tempvalue);
                mModel.setPrecipitation(precvalue);
            } catch (NumberFormatException e) {
                throw new InputException( e.getMessage());
            }
        }
    }

}
