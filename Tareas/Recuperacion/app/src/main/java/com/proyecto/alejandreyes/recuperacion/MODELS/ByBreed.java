package com.proyecto.alejandreyes.recuperacion.MODELS;

import java.util.ArrayList;

public class ByBreed {
    private String status ;
    private ArrayList<String> message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
}
