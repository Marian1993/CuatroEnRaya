package com.company;

import java.util.Scanner;

public class Taulell {

    private Casella[][] taulell;
    private final int NUMFILES = 8;
    private final int NUMCOLUMNES = 8;
    private final static Scanner sc = new Scanner(System.in);

    public Taulell(){

    }
    
    public void inicialitzarTaulell( Casella[][] caselles){

        this.taulell = caselles;

        for (int i = 0; i < taulell.length; i++) {

            for (int j = 0; j < taulell[i].length; j++) {

                taulell[i][j] = new Casella();
            }
        }
    }

    public void colocarFitxa(int posicio, Jugador jugador){

        for (int i = taulell.length-1; i >= 0; i--) {

            if(taulell[i][posicio].isBuida()){

                taulell[i][posicio].setValorCasella(jugador.getId());
                taulell[i][posicio].setBuida(false);
                jugador.addIntents(1);
                break;
            }
        }
    }



    public int getNumFiles() {
        return NUMFILES;
    }

    public int getNumColumnes() {
        return NUMCOLUMNES;
    }
}
