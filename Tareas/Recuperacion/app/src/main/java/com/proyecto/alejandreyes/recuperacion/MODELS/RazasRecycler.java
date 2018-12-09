package com.proyecto.alejandreyes.recuperacion.MODELS;

import java.util.ArrayList;

/**
 * Clase auxiliar que ayuda a crear una clase base para el recycler view
 */
public class RazasRecycler {
    private String nombreRaza ;
    private ArrayList<String> subrazas ;

    public RazasRecycler() {
    }

    public RazasRecycler(String nombreRaza, ArrayList<String> subrazas) {
        this.nombreRaza = nombreRaza;
        this.subrazas = subrazas;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public ArrayList<String> getSubrazas() {
        return subrazas;
    }

    public void setSubrazas(ArrayList<String> subrazas) {
        this.subrazas = subrazas;
    }

    public void setInformacion(String nombre,ArrayList<String> subrazas){
        this.nombreRaza = nombre;
        this.subrazas = subrazas;
    }
}
