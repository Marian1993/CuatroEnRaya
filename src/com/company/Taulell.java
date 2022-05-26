package com.company;

public class Taulell {

    private Casella[][] casellas;
    public final int NUMFILES = 8;
    public final int NUMCOLUMNES = 8;
    private final int CASELLESTOTALS = 64;
    private int casellesOmplides = 0;


    public Taulell(){
        casellas = new Casella[NUMFILES][NUMCOLUMNES];
        inicialitzarTaulell();
    }
    
    private void inicialitzarTaulell(){

        for (int i = 0; i < casellas.length; i++) {

            for (int j = 0; j < casellas[i].length; j++) {

                casellas[i][j] = new Casella();
            }
        }
    }

    public Posicio colocarFitxa(int posicio, Jugador jugador){

        for (int i = casellas.length-1; i >= 0; i--) {

            if(casellas[i][posicio].isBuida()){

                casellas[i][posicio].setValorCasella(jugador.getId());
                casellas[i][posicio].setBuida(false);
                jugador.addIntents(1);
                addCasellesOmplides(1);
                return new Posicio(i,posicio);
            }
        }
        return new Posicio(0,0);
    }

    //Aquest metode retorna un boolean si el taulell no li queden més caselles buides
    public boolean taulellComplet(){

        return getCasellesOmplides() == CASELLESTOTALS;
    }

    //Aqui fa lescomprovacions a totes les direccions
    public boolean partidaGuanyada(Posicio posicio, Jugador jugador){

        if(trovarPrimeraFitxaDiagonalEsquerra(posicio,jugador)){
            return true;
        }else if (trovarPrimeraFitxaDiagonalDreta(posicio,jugador)){
            return true;
        }else if(trovarPrimeraFitxaVertical(posicio, jugador)){
            return true;
        }else if(trovarPrimeraFitxaHorizontal(posicio, jugador)){
            return true;
        }
        return false;
    }

    //Comprovacio del connecta 4 de manera diagonal d'esquerra a dreta
    private boolean comprovacioDiagonalEsquerra(Posicio posicio, Jugador jugador){

        int cuatreEnLinea = 0;

        for (int i = 0; i < 4; i++) {

            if ( posicio.getPosicioX() >= 0 && posicio.getPosicioY() >= 0 && posicio.getPosicioX() < NUMFILES && posicio.getPosicioY() < NUMCOLUMNES){

                if (casellas[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                    cuatreEnLinea++;
                }
                if(cuatreEnLinea == 4){

                    return true;
                }
                posicio.setPosicioX(posicio.getPosicioX() - 1);
                posicio.setPosicioY(posicio.getPosicioY() - 1);
            }
        }
        return false;
    }

    private boolean trovarPrimeraFitxaDiagonalEsquerra(Posicio pos, Jugador jugador){

        Posicio posicio = new Posicio(pos.getPosicioX(), pos.getPosicioY());

        while(true){

            if(posicio.getPosicioY() != NUMCOLUMNES-1 && posicio.getPosicioX() != NUMFILES-1 && casellas[posicio.getPosicioX() + 1][posicio.getPosicioY() + 1].getValorCasella() == jugador.getId()){

                posicio.setPosicioX(posicio.getPosicioX() + 1);
                posicio.setPosicioY(posicio.getPosicioY() + 1);
            }else {
                break;
            }
        }
        return comprovacioDiagonalEsquerra(posicio, jugador);
    }

    //Comprovacio del connecta 4 de manera diagonal de dreta a esquerra
    private boolean comprovacioDiagonalDreta(Posicio posicio, Jugador jugador){

        int cuatreEnLinea = 0;

        for (int i = 0; i < 4; i++) {

            if ( posicio.getPosicioX() >= 0 && posicio.getPosicioY() >= 0 && posicio.getPosicioX() < NUMFILES && posicio.getPosicioY() < NUMCOLUMNES){

                if (casellas[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                    cuatreEnLinea++;
                }
                if(cuatreEnLinea == 4){

                    return true;
                }
                posicio.setPosicioX(posicio.getPosicioX() - 1);
                posicio.setPosicioY(posicio.getPosicioY() + 1);
            }
        }
        return false;
    }
    private boolean trovarPrimeraFitxaDiagonalDreta(Posicio pos, Jugador jugador){

        Posicio posicio = new Posicio(pos.getPosicioX(), pos.getPosicioY());

        while(true){

            if(posicio.getPosicioX() != NUMFILES-1 && posicio.getPosicioY() != 0 && casellas[posicio.getPosicioX() + 1][posicio.getPosicioY() - 1].getValorCasella() == jugador.getId()){

                posicio.setPosicioX(posicio.getPosicioX() + 1);
                posicio.setPosicioY(posicio.getPosicioY() - 1);
            }else {
                break;
            }
        }
        return comprovacioDiagonalDreta(posicio, jugador);
    }

    //Comprovacio del connecta 4 de manera vertical
    private boolean comprovacioVertical(Posicio posicio, Jugador jugador){

        int cuatreEnLinea = 0;

        for (int i = 0; i < 4; i++) {

            if ( posicio.getPosicioX() >= 0 && posicio.getPosicioY() >= 0 && posicio.getPosicioX() < NUMFILES && posicio.getPosicioY() < NUMCOLUMNES){

                if (casellas[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                    cuatreEnLinea++;
                }
                if(cuatreEnLinea == 4){

                    return true;
                }
                posicio.setPosicioX(posicio.getPosicioX() - 1);
            }
        }
        return false;
    }

    private boolean trovarPrimeraFitxaVertical(Posicio pos, Jugador jugador){

        Posicio posicio = new Posicio(pos.getPosicioX(), pos.getPosicioY());

        while(true){

            if(posicio.getPosicioX() != 7 && casellas[posicio.getPosicioX() + 1][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                posicio.setPosicioX(posicio.getPosicioX() + 1);
            }else {
                break;
            }
        }
        return comprovacioVertical(posicio, jugador);
    }

    //Comprovacio del connecta 4 de manera horizontal
    private boolean comprovacioHorizontal(Posicio posicio, Jugador jugador){

        int cuatreEnLinea = 0;

        for (int i = 0; i < 4; i++) {

            if ( posicio.getPosicioX() >= 0 && posicio.getPosicioY() >= 0 && posicio.getPosicioX() < NUMFILES && posicio.getPosicioY() < NUMCOLUMNES){

                if (casellas[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                    cuatreEnLinea++;
                }
                if(cuatreEnLinea == 4){

                    return true;
                }
                posicio.setPosicioY(posicio.getPosicioY() + 1);
            }
        }
        return false;
    }

    private boolean trovarPrimeraFitxaHorizontal(Posicio pos, Jugador jugador){

        Posicio posicio = new Posicio(pos.getPosicioX(), pos.getPosicioY());

        while(true){

            if (posicio.getPosicioY() != 0  && casellas[posicio.getPosicioX()][posicio.getPosicioY() - 1].getValorCasella() == jugador.getId()){

                posicio.setPosicioY(posicio.getPosicioY() - 1);
            }else {
                break;
            }
        }
        return comprovacioHorizontal(posicio, jugador);
    }

    public int getCasellesOmplides() {
        return casellesOmplides;
    }

    public void addCasellesOmplides(int casellesOmplides) {
        this.casellesOmplides += casellesOmplides;
    }

    public Casella[][] getCasellas() {
        return casellas;
    }
}
