package com.ptrml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Oznacuva dali programata da izleze od loop
     */
    private static boolean state = true;
    /**
     * Spisok so postavenite observeri. Cuva referenca za sekoj observer za da ovozmozi brisenje.
     */
    private static List<Observer> obs_list;

    private static Subject regA,regB;

    public static void main(String[] args) {

        //Gi inicijalizira registrite
        regA = new Subject();
        regB = new Subject();
        regA.setVal(10);
        regB.setVal(5);

        // cita korisnicki vnes
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String inp_str = "";

        obs_list = new ArrayList<>();

        while(state)
        {
            System.out.println("Set_val[A] Set_val[B] [+]AddObserver [-]RemoveObserver e[X]it > ");
            try{
                inp_str = bufferRead.readLine();
            }
            catch(IOException e)
            {
                System.err.println(e.getMessage());
            }

            switch (inp_str.toUpperCase())
            {
                case "A":
                    System.out.println(">> Value=");
                    try {
                        float val = Float.parseFloat(bufferRead.readLine());
                        regA.setVal(val);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "B":
                    System.out.println(">> Value=");
                    try {
                        float val = Float.parseFloat(bufferRead.readLine());
                        regB.setVal(val);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "+":
                    try {
                        addObserver();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "-":
                    System.out.println("Remove Observer (#):");
                    try {
                        int i = Integer.parseInt(bufferRead.readLine());
                        removeObserver(i);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;
                case "X":
                    state = false;
                    break;
                default:
                    break;

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * @param i    korisnickiot izbor na observer
     * @throws Exception    brisenjeto ne e uspesno
     */
    private static void removeObserver(int i) throws Exception {
        for(Observer obs : obs_list)
        {
            if((obs.getId() == i))
            {
                obs.unregister();
                obs_list.remove(obs);
                obs = null;
                return;
            }
        }

        throw new Exception("No such observer");
    }

    /**
     * Dodava observer vo listata
     * @throws Exception dodavanjeto ne e uspesno
     */
    private static void addObserver() throws Exception {
        System.out.println(">> Set New Observer (A|B)(+|-|*|/) <num>):");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        Character op = null;
        try {
            Character reg = (char) bufferRead.read();
            op = (char) bufferRead.read();
            float val = Float.parseFloat(bufferRead.readLine());
            switch(Character.toUpperCase(reg))
            {
                case 'A':
                    try {
                        obs_list.add(new Observer(regA,op,val));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 'B':
                    try {
                        obs_list.add(new Observer(regB,op,val));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());                        
                    }
                    break;
                default:
                    throw new Exception("Cant find register");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }


}
