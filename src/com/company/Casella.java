package com.company;

public class Casella {

    private boolean buida;
    private final int j1 = 0;
    private final int j2 = 1;

    public Casella(){
        buida = true;
    }

    public boolean isBuida() {
        return buida;
    }

    public void setBuida(boolean buida) {
        this.buida = buida;
    }
}
