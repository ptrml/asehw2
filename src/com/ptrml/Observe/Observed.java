package com.ptrml.Observe;

/**
 * Created by Pepo123 on 12/1/2016.
 */
public interface Observed {
    void registerObserver(Observing _obsrv);
    void unregisterObserver(Observing _obsrv);
    void notifyObservers();
}
