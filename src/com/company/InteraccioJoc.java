package com.company;

public class InteraccioJoc {

    private static final Jugador j1 = new Jugador(1);
    private static final Jugador j2 = new Jugador(2);
    private final static Taulell taulell = new Taulell();


    public static void partida() {

        Casella[][] casella = new Casella[taulell.getNumFiles()][taulell.getNumColumnes()];
        taulell.inicialitzarTaulell(casella);
        Input.nomJugador(j1);
        Input.nomJugador(j2);

        while (true) {

            Output.imprimirTaulell(casella);
            taulell.colocarFitxa(Input.posarFitxa(j1), j1);
            Output.imprimirTaulell(casella);
            taulell.colocarFitxa(Input.posarFitxa(j2), j2);
        }


    }
}

