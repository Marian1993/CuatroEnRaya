package com.company;

public class Color {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final String[] COLORS = {ANSI_BLUE,ANSI_YELLOW};

    public static String colorJugador(int id){

        return COLORS[id-1] + "●"+ Color.ANSI_RESET;

    }

}
