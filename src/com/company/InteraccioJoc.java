package com.company;

public class InteraccioJoc {

    private static final Jugador j1 = new Jugador(1);
    private static final Jugador j2 = new Jugador(2);
    private final static Taulell taulell = new Taulell();

    public static void partida() {

        do {

            Casella[][] casella = new Casella[taulell.NUMFILES][taulell.NUMCOLUMNES];
            taulell.inicialitzarTaulell(casella);
            Input.nomJugador(j1);
            Input.nomJugador(j2);
            boolean partidaGuanyada = false;


            while (!taulell.taulellComplet()) {

                Output.imprimirTaulell(casella);
                if (taulell.partidaGuanyada(taulell.colocarFitxa(Input.posarFitxa(j1), j1), j1)) {
                    System.out.println("El jugador " + j1.getNom() + " ha guanyat amb " + j1.getIntents() + " intents");
                    Output.imprimirTaulell(casella);
                    partidaGuanyada = true;
                    break;
                }
                Output.imprimirTaulell(casella);
                if (taulell.partidaGuanyada(taulell.colocarFitxa(Input.posarFitxa(j2), j2), j2)) {
                    System.out.println("El jugador " + j2.getNom() + " ha guanyat amb " + j2.getIntents() + " intents");
                    Output.imprimirTaulell(casella);
                    partidaGuanyada = true;
                    break;
                }
            }
            if(!partidaGuanyada){
                Output.imprimirTaulell(casella);
                System.out.println("El taulell ja no te més posicions per omplir, heu empatat!☺");
            }

        }while (Input.reiniciaJoc());
    }

}

