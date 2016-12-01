package com.ptrml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean state = true;

    public static void main(String[] args) {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String inp_str = "";

        while(state)
        {
            System.out.println("Set_val[A] Set_val[B] [+]AddObserver [-]RemoveObserver e[X]it > ");
            try{
                inp_str = bufferRead.readLine();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            switch (inp_str.toUpperCase())
            {
                case "A":
                    break;
                case "B":
                    break;
                case "+":
                    break;
                case "-":
                    break;
                case "X":
                    state = false;
                    break;
                default:
                    break;

            }

        }

    }

}
