/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Bertiwi
 */
public class PreguntaExtra {
    private int respuesta_correcta;
    private String pregunta_extra;
    private HashMap<Integer, String> respuestas_posibles;

    public PreguntaExtra(int respuesta_correcta, String pregunta_extra, HashMap<Integer, String> respuestas_posibles) {
        this.respuesta_correcta = respuesta_correcta;
        this.pregunta_extra = pregunta_extra;
        this.respuestas_posibles = respuestas_posibles;
    }

    public int getRespuesta_correcta() {
        return respuesta_correcta;
    }

    public String getPregunta_extra() {
        return pregunta_extra;
    }

    public HashMap<Integer, String> getRespuestas_posibles() {
        return respuestas_posibles;
    }
}
