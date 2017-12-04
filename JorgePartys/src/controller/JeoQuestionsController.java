/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Pregunta;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.JeoQuestionsModel;
import view.JeoGUI;
import view.JeoQuestions;

/**
 *
 * @author Susana
 */
public class JeoQuestionsController implements ActionListener {

    private JeoQuestionsModel model;
    private JeoQuestions view;

    public JeoQuestionsController(JeoQuestionsModel model, JeoQuestions view) {
        this.model = model;
        this.view = view;

        setUpButtons();
    }

    public void setUpButtons() {

        Pregunta aux = model.getPregunta();
        HashMap auxMap = aux.getRespuestas_posibles();

        view.pregunta.setText(aux.getPregunta_texto());
        view.opcio1.setText((String) auxMap.get(1));
        view.opcio2.setText((String) auxMap.get(2));
        view.opcio3.setText((String) auxMap.get(3));

        view.opcio1.addActionListener(this);
        view.opcio2.addActionListener(this);
        view.opcio3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        JButton buttonSelected = (JButton) actionEvent.getSource();
        Pregunta aux = model.getPregunta();
        HashMap auxMap = aux.getRespuestas_posibles();
        
        if (buttonSelected.getText().equals(auxMap.get(aux.getPregunta_correcta()))) {
            JOptionPane.showMessageDialog(null, "Correcto");    
            model.jugador.preguntaAcertada();
            model.jugador.sumarPuntuacion(aux.getPuntuacio_pregunta());
            if(model.jugador.getNickname().equals("Jugador 1")){
            model.player1.setText(model.jugador.getNickname() + ": " + model.jugador.getPuntuation());
            }else{
            model.player2.setText(model.jugador.getNickname() + ": " + model.jugador.getPuntuation());
            }
        
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Falso");
            model.jugador.preguntaFallada();
            model.jugador.restarPuntuacion(aux.getPuntuacio_pregunta());
            if(model.jugador.getNickname().equals("Jugador 1")){
            model.player1.setText(model.jugador.getNickname() + ": " + model.jugador.getPuntuation());
            }else{
            model.player2.setText(model.jugador.getNickname() + ": " + model.jugador.getPuntuation());
            }
            view.dispose();
        }

    }

}
