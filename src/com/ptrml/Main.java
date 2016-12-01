package com.ptrml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean state = true;

    public static void main(String[] args) {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String inp_str = "";
        Subject regA = new Subject();
        Subject regB = new Subject();
        regA.setVal(10);
        regB.setVal(5);

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
                    System.out.println(">> Value=");
                    try {
                        float val = Float.parseFloat(bufferRead.readLine());
                        regA.setVal(val);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "B":
                    System.out.println(">> Value=");
                    try {
                        float val = Float.parseFloat(bufferRead.readLine());
                        regB.setVal(val);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "+":
                    System.out.println(">> Set New Observer (A|B)(+|-|*|/) <num>):");
                    Character op = null;
                    try {
                        Character reg = (char) bufferRead.read();
                        op = (char) bufferRead.read();
                        float val = Float.parseFloat(bufferRead.readLine());
                        switch(Character.toUpperCase(reg))
                        {
                            case 'A':
                                try {
                                    new Observer(regA,op,val);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 'B':
                                try {
                                    new Observer(regB,op,val);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case "-":
                    System.out.println("Remove Observer (#):");
                    try {
                        int i = bufferRead.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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
