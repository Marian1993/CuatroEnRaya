package com.company;

public class Output {

    public static void imprimirTaulell(Casella[][] casella){

        for (int i = 0; i < casella.length; i++) {

            for (int j = 0; j < casella[i].length; j++) {

                if(casella[i][j].isBuida()){
                    System.out.print("【   】");
                }else {
                    System.out.print("【 " + Color.colorJugador(casella[i][j].getValorCasella()) + " 】");
                }
            }
            System.out.println();
        }
        posarNumerosAdaltAbaix(casella);
    }

    private static void posarNumerosAdaltAbaix(Casella[][] casella){

        for (int i = 0; i < casella.length; i++) {
            if(i == 0){
                System.out.print("   " + (i+1) + "  ");
            } else if(i < 4){
                System.out.print("   " + (i+1) + "  ");
            }else{
                System.out.print("    " + (i+1) + " ");
            }
        }
        System.out.println();
    }
}
