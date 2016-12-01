package com.ptrml;

import com.ptrml.Observe.Observed;
import com.ptrml.Observe.Observing;

/**
 * Created by Pepo123 on 12/1/2016.
 */
public class Observer implements Observing {

    private float value;
    private Calculator calc;


    public Observer(Subject subject, char c, float oval) throws Exception {
        this.value = subject.getVal();
        calc = new Calculator();
        calc.setOp(c,oval);
        calc.executeOp(subject.getVal());

        subject.registerObserver(this);
    }

    @Override
    public void notify(float _val) {
        this.value = _val;

        try {
            System.out.printf("Observer is %f \n",calc.executeOp(this.value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
