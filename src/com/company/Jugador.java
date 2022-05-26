package com.company;

public class Jugador {

    private String nom;
    private final int ID;
    private int intents;

    public Jugador(int id){

        this.ID = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIntents() {
        return intents;
    }

    public void addIntents(int intents) {
        this.intents += intents;
    }

    public int getId() {
        return ID;
    }
}
