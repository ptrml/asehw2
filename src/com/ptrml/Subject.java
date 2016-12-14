package com.ptrml;

import com.ptrml.Observe.Observed;
import com.ptrml.Observe.Observing;

import java.util.ArrayList;
import java.util.List;

/**
 * Nadgleduvaniot element. Pri promena na cuvanata vrednost gi izvestuva nadgleduvacite za promenata.
 */
public class Subject implements Observed {
    private float val;
    private List<Observing> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }


    public float getVal() {
        return val;
    }

    /**
     * Setter
     * @param val float
     */
    public void setVal(float val) {
        this.val = val;
        notifyObservers();
    }


    /**
     * dodava observer
     * @param _obsrv Observerot koj se dodava
     */
    @Override
    public void registerObserver(Observing _obsrv) {

        observers.add(_obsrv);
        notifyObservers();
    }

    /**
     * @param _obsrv Observerot koj go isfrla od listata nadgleduvaci
     */
    @Override
    public void unregisterObserver(Observing _obsrv) {
        observers.remove(_obsrv);
        notifyObservers();
    }

    /**
     * Gi izvestuva observerite deka e napravena promena
     */
    @Override
    public void notifyObservers()
    {
        for(Observing ob : observers)
        {
            ob.notifyObserving();
        }
    }

}
