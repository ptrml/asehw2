package com.ptrml;

import com.ptrml.Observe.Observed;
import com.ptrml.Observe.Observing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pepo123 on 11/30/2016.
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

    public void setVal(float val) {
        this.val = val;
        notifyObservers();
    }


    @Override
    public void registerObserver(Observing _obsrv) {

        observers.add(_obsrv);
        notifyObservers();
    }

    @Override
    public void unregisterObserver(Observing _obsrv) {
        observers.remove(_obsrv);
        notifyObservers();
    }

    @Override
    public void notifyObservers()
    {
        for(Observing ob : observers)
        {
            ob.notify(this.val);
        }
    }

}
