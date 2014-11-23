/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaces.IModelListener;
import exceptions.InputException;

/**
 * @author Valy
 *
 */
public class Tema6Model {

    // Member variable defining the temperature and the precipitation
    private int mTemperature;
    private int mPrecipitation;

    private List<IModelListener> mListeners;

    /**
     * Constructor
     */
    public Tema6Model() {
       mTemperature = 0;
       mPrecipitation = 0;
    }

    /**
     * Set the temperature.
     * @param tempvalue 
     *
     * @param value New value for the temperature.
     */
    public void setTemperature(int tempvalue) throws InputException {
        try {
        	Random randomGenerator = new Random();
            mTemperature = randomGenerator.nextInt(40);
            notifyListeners();
        } catch (NumberFormatException e) {
            throw new InputException(e.getMessage());
        }
    }
    
    /**
     * Set the precipitations.
     * @param tempvaprecvaluelue 
     *
     * @param value New value for the precipitations.
     */
    public void setPrecipitation(int precvalue) throws InputException {
        try {
        	Random randomGenerator = new Random();
            mPrecipitation = randomGenerator.nextInt(100);
            notifyListeners();
        } catch (NumberFormatException e) {
            throw new InputException(e.getMessage());
        }
    }

    /**
     * Return the temperature.
     */
    public int getTemperature() {
        return mTemperature;
    }
    
    /**
     * Return the precipitations.
     */
    public int getPrecipitation() {
        return mPrecipitation;
    }

    /**
     * Adds the view listener to the list
     *
     * @param listener The model event listener
     */
    public void addModelListener(IModelListener listener) {
        if (mListeners == null) {
            mListeners = new ArrayList<IModelListener>();
        }

        mListeners.add(listener);
    }

    /**
     * Notifies the views listeners of the changed state (value)
     */
    private void notifyListeners() {
        if (mListeners != null && !mListeners.isEmpty()) {
            for (IModelListener listener : mListeners)
                listener.onUpdate();
        }
    }
}
