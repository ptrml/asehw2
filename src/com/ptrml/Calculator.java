package com.ptrml;

import com.ptrml.Operator.*;

/**
 * Created by ptrml on 12/1/2016.
 */
public class Calculator {
    private Operator operator;
    private float value;
    
    void setOp(char c,float x) throws Exception {
        value = x;
        switch (c)
        {
            case '+':
                operator = new Adder();
                break;
            case '-':
                operator = new Subtractor();
                break;
            case '*':
                operator = new Multiplier();
                break;
            case '/':
                operator = new Divider();
                break;
            default:
                throw new Exception("No such operator!");

        }
    }
    
    float executeOp(float opval) throws Exception
    {
        if(this.operator == null)
            throw new Exception("Operator not set!");

        return operator.execute(opval,value);
    }
}
