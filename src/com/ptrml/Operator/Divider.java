package com.ptrml.Operator;

/**
 * Created by Pepo123 on 12/1/2016.
 */
public class Divider implements Operator{
    @Override
    public float execute(float var1, float var2) {
        return var1/var2;
    }
}