package com.company;

import java.util.Scanner;

public class PosarNumero {

    private final static Scanner sc = new Scanner(System.in);
    public static int esNecessitaNumero(){

        while(true) {
            String paraula = sc.nextLine();
            int num;
            try {

                num = Integer.parseInt(paraula);

                return num;

            } catch (NumberFormatException e) {

                System.err.print("Has de posar un número: ");
            }
        }
    }
}
