package model;

import java.util.ArrayList;

public class Pregunta {
    private String pregunta;
    private int puntuacion;
    private ArrayList<Respuesta> respostes;           

    public Pregunta(int puntuacion,String pregunta,  ArrayList<Respuesta> respostes) {
        this.pregunta = pregunta;
        this.puntuacion = puntuacion;
        this.respostes = respostes;
    }

    public String getPregunta() {
        return pregunta;
    }

    public ArrayList<Respuesta> getRespostes() {
        
        return respostes;
    }    

    public int getPuntuacion() {
        return puntuacion;
    }
    
    
          
    
    
}
