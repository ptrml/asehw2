package com.ptrml;

import com.ptrml.Operator.*;

/**
 * Strategy context
 * Gi izvrsuva operaciite na opeatorot.
 */
public class Calculator {
    private Operator operator;
    private float value;

    /**
     * Go setira operatorot na ovoj kalkulator
     * @param c karakterot na operatgorot
     * @param x vrednosta so koja operira kalkulatorot
     * @throws Exception od factory
     */
    void setOp(char c,float x) throws Exception {

        value = x;
        operator = OperatorFactory.getOperator(c);

    }

    /**
     * @param opval vrednosta nad koja operira kalkulatorot
     * @return float rezultatot
     * @throws Exception Loso setiran kalkulator
     */
    float executeOp(float opval) throws Exception
    {
        if(this.operator == null)
            throw new Exception("Operator not set!");

        return operator.execute(opval,value);
    }
}
