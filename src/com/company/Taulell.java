package com.company;

public class Taulell {

    private Casella[][] taulell;
    private final int NUMFILES = 8;
    private final int NUMCOLUMNES = 8;

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

    public Posicio colocarFitxa(int posicio, Jugador jugador){

        for (int i = taulell.length-1; i >= 0; i--) {

            if(taulell[i][posicio].isBuida()){

                taulell[i][posicio].setValorCasella(jugador.getId());
                taulell[i][posicio].setBuida(false);
                jugador.addIntents(1);
                return new Posicio(i,posicio);
            }
        }
        return new Posicio(0,0);
    }

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

            if ( posicio.getPosicioX() >= 0 && posicio.getPosicioY() >= 0 && posicio.getPosicioX() < getNumFiles() && posicio.getPosicioY() < getNumColumnes()){

                if (taulell[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

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

            if (taulell[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                if(posicio.getPosicioY() != getNumColumnes()-1 && posicio.getPosicioX() != getNumFiles()-1){

                    posicio.setPosicioX(posicio.getPosicioX() + 1);
                    posicio.setPosicioY(posicio.getPosicioY() + 1);
                }else {
                    break;
                }
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

            if ( posicio.getPosicioX() >= 0 && posicio.getPosicioY() >= 0 && posicio.getPosicioX() < getNumFiles() && posicio.getPosicioY() < getNumColumnes()){

                if (taulell[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

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

            if (taulell[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                if(posicio.getPosicioX() != getNumFiles()-1 && posicio.getPosicioY() != 0 ){

                    posicio.setPosicioX(posicio.getPosicioX() + 1);
                    posicio.setPosicioY(posicio.getPosicioY() - 1);
                }else {
                    break;
                }
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

            if ( posicio.getPosicioX() >= 0 && posicio.getPosicioY() >= 0 && posicio.getPosicioX() < getNumFiles() && posicio.getPosicioY() < getNumColumnes()){

                if (taulell[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

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

            if (taulell[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                if(posicio.getPosicioX() != 7){

                    posicio.setPosicioX(posicio.getPosicioX() + 1);
                }else {
                    break;
                }
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

            if ( posicio.getPosicioX() >= 0 && posicio.getPosicioY() >= 0 && posicio.getPosicioX() < getNumFiles() && posicio.getPosicioY() < getNumColumnes()){

                if (taulell[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

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

            if (taulell[posicio.getPosicioX()][posicio.getPosicioY()].getValorCasella() == jugador.getId()){

                if (posicio.getPosicioY() != 0){

                    posicio.setPosicioY(posicio.getPosicioY() - 1);
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        return comprovacioHorizontal(posicio, jugador);
    }

    public int getNumFiles() {
        return NUMFILES;
    }

    public int getNumColumnes() {
        return NUMCOLUMNES;
    }
}
