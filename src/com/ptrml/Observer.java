package com.ptrml;

import com.ptrml.Observe.Observing;

/**
 * Go nadgleduva subject, ako subject napravi promena, go koristi Calculator za da ja izvrsi operacijata i ja prikazuva novata vrednost
 */
public class Observer implements Observing {

    /**
     * Brojac koj ovozmozuva unikatno id za sekoj observer
     */
    public static int counter = 0;

    /**
     * Id na observerot
     */
    private int id;

    /**
     * Go cuva nadgleduvaniot objekt
     */
    private Subject subject;

    /**
     * Gi pravi baranite operacii
     */
    private Calculator calc;


    /**
     * Konstruktor, pravi zapis na objektot koj ke se nadgleduva i ja setira operacijata koja ke se pravi
     * @param subject objektot koj se nadgleduva
     * @param c operacijata sto ke ja izvrsuva operatorot
     * @param oval vrednosta so koja ke pravi operacija kalkulatorot
     * @throws Exception greska pri registriranje na observerot
     */
    public Observer(Subject subject, char c, float oval) throws Exception {
        this.subject = subject;
        calc = new Calculator();
        calc.setOp(c,oval);
        calc.executeOp(this.subject.getVal());

        this.id = counter++;

        subject.registerObserver(this);
    }

    /**
     * metodot koj go povikuva subjektot za da go izvesti za napravenata promena
     */
    @Override
    public void notifyObserving() {
        try {
            System.out.printf("Observer %d is %f \n",this.id,calc.executeOp(this.subject.getVal()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @return getter
     */
    public int getId() {
        return id;
    }

    /**
     * se otkazuva od nadgleduvanjeto na subjektot
     */
    @Override
    public void unregister()
    {
        this.subject.unregisterObserver(this);
    }
}
