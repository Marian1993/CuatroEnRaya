package com.company;

public class InteraccioJoc {

    private static final Jugador j1 = new Jugador(1);
    private static final Jugador j2 = new Jugador(2);
    private final static Taulell taulell = new Taulell();
    private static boolean partidaGuanyada = false;


    public static void partida() {

        Casella[][] casella = new Casella[taulell.getNumFiles()][taulell.getNumColumnes()];
        taulell.inicialitzarTaulell(casella);
        Input.nomJugador(j1);
        Input.nomJugador(j2);

        while (!partidaGuanyada) {

            Output.imprimirTaulell(casella);
            if(taulell.partidaGuanyada(taulell.colocarFitxa(Input.posarFitxa(j1), j1),j1)){
                partidaGuanyada = true;
                System.out.println("El jugador: " + j1.getNom() + " ha guanyat");

            }
            Output.imprimirTaulell(casella);
            if(taulell.partidaGuanyada(taulell.colocarFitxa(Input.posarFitxa(j2), j2),j2) && !partidaGuanyada){
                partidaGuanyada = true;
                System.out.println("El jugador: " + j2.getNom() + " ha guanyat");

            }
        }
    }
}

