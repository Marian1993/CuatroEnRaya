package com.company;

import java.util.Scanner;

public class Input {

    private final static Scanner sc = new Scanner(System.in);

    public static void nomJugador(Jugador jugador){

        System.out.print("Nom del jugador " + jugador.getId() + " :");
        jugador.setNom(sc.next());

    }
    public static int posarFitxa( Jugador jugador){

        System.out.print(jugador.getNom() + " posa un numero : ");
        int posicio = PosarNumero.esNecessitaNumero() - 1;

        while(!(posicio >= 0 && posicio < 9)){

            System.out.print("Has posat un numero incorrecta, torna a posar un numero: ");
            posicio = PosarNumero.esNecessitaNumero() - 1;
        }
        return posicio;
    }

    public static boolean reiniciaJoc(){

        System.out.println("Reiniciar partida = 0 \n" + "Per sortir pitja cualsevol numero");
        int reinici = PosarNumero.esNecessitaNumero();

        return reinici == 0;
    }
}
