/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Susana
 */
public class JeoQuestionsModel {
    
    private Pregunta pregunta;

    public JeoQuestionsModel(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }
    
    
}
