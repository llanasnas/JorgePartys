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
    public Jugador jugador;

    public JeoQuestionsModel(Pregunta pregunta,Jugador jugador) {
        this.pregunta = pregunta;
        this.jugador= jugador;
        
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

   
    
    
}
