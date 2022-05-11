package com.company;

public class Casella {

    private boolean buida;
    private int valorCasella;

    public Casella(){

        buida = true;

    }

    public boolean isBuida() {
        return buida;
    }

    public void setBuida(boolean buida) {
        this.buida = buida;
    }

    public int getValorCasella() {
        return valorCasella;
    }

    public void setValorCasella(int valorCasella) {
        this.valorCasella = valorCasella;
    }
}
