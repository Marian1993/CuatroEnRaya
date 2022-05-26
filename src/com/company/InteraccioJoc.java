package com.company;

public class InteraccioJoc {

    private static Jugador[] jugadors = {new Jugador(1),new Jugador(2)};
    private final static Taulell taulell = new Taulell();


    public static void partida() {

        do {

            Input.nomJugador(jugadors[0]);
            Input.nomJugador(jugadors[1]);

            int torn = 0;
            boolean partidaGuanyada = false;


            while (!taulell.taulellComplet()) {

                Output.imprimirTaulell(taulell.getCasellas());
                if (taulell.partidaGuanyada(taulell.colocarFitxa(Input.posarFitxa(jugadors[torn%2]), jugadors[torn%2]), jugadors[torn%2])) {
                    System.out.println("El jugador " + jugadors[torn%2].getNom() + " ha guanyat amb " + jugadors[torn%2].getIntents() + " intents");
                    Output.imprimirTaulell(taulell.getCasellas());
                    partidaGuanyada = true;
                    break;
                }
                torn++;
            }
            if(!partidaGuanyada){
                Output.imprimirTaulell(taulell.getCasellas());
                System.out.println("El taulell ja no te més posicions per omplir, heu empatat!☺");
            }

        }while (Input.reiniciaJoc());
    }

}

