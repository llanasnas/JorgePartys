package model;

import java.util.HashMap;

public class Pregunta {
    private int categoria;
    private int respuesta_correcta;
    private int nivel_dificultad;
    private int puntuacio_pregunta;
    private String pregunta_texto;
    private HashMap<Integer, String> respuestas_posibles;

    public Pregunta(int categoria, int pregunta_correcta, int nivel_dificultad, int puntuacio_pregunta, String pregunta_texto, HashMap<Integer, String> respuestas_posibles) {
        this.categoria = categoria;
        this.respuesta_correcta = pregunta_correcta;
        this.nivel_dificultad = nivel_dificultad;
        this.puntuacio_pregunta = puntuacio_pregunta;
        this.pregunta_texto = pregunta_texto;
        this.respuestas_posibles = respuestas_posibles;
    }

    public void setPuntuacio_pregunta(int puntuacio_pregunta) {
        this.puntuacio_pregunta = puntuacio_pregunta;
    }

    public int getPuntuacio_pregunta() {
        return puntuacio_pregunta;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getRespuesta_correcta() {
        return respuesta_correcta;
    }

    public int getNivel_dificultad() {
        return nivel_dificultad;
    }

    public String getPregunta_texto() {
        return pregunta_texto;
    }

    public HashMap<Integer, String> getRespuestas_posibles() {
        return respuestas_posibles;
    }

    
    @Override
    public String toString() {
        return "Pregunta{" + "categoria=" + categoria + ", pregunta_correcta=" + respuesta_correcta + ", nivel_dificultad=" + nivel_dificultad + ", puntuacio_pregunta=" + puntuacio_pregunta + ", pregunta_texto=" + pregunta_texto + ", respuestas_posibles=" + respuestas_posibles + '}';
    }



}
