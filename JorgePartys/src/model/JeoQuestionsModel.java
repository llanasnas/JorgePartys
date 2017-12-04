/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JLabel;

/**
 *
 * @author Susana
 */
public class JeoQuestionsModel {
    
    private Pregunta pregunta;
    public Jugador jugador;
    public JLabel player1;
    public JLabel player2;

    public JeoQuestionsModel(Pregunta pregunta, Jugador jugador, JLabel player1,JLabel  player2) {
        this.pregunta = pregunta;
        this.jugador = jugador;
        this.player1 = player1;
        this.player2 = player2;
    }

   

    public Pregunta getPregunta() {
        return pregunta;
    }

   
    
    
}
