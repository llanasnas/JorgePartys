/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.JeoModel;
import view.JeoGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedHashSet;
import model.JeoQuestionsModel;
import model.Jugador;
import model.PodiumModel;
import model.Pregunta;
import view.JeoQuestions;
import view.PodiumView;

/**
 * @author Alumne
 */
public class JeoController implements ActionListener {

    private JeoGUI view;
    private JeoModel model;

    public JeoController(JeoGUI view, JeoModel model) {
        this.view = view;
        this.model = model;
        setUpButtons();
    }

    public void setUpButtons() {
        view.player1Info.setText(String.valueOf(model.jugador1.getNickname()+ ": " + model.jugador1.getPuntuation()));
        view.player2Info.setText(String.valueOf(model.jugador2.getNickname()+ ": " + model.jugador2.getPuntuation()));
        String[] valors_str = model.getPreu_preguntes();
        LinkedHashSet<Pregunta> auxLinkedHashSet = model.all_questions;
        Pregunta auxPregunta;    
        for (int i = 0; i < 5; i++) {
//            this.view.buttons[i-1]=new JButton();
            for (int j = 0; j < 6; j++) {
                Iterator it = auxLinkedHashSet.iterator();
                    while (it.hasNext()) {
                        auxPregunta = (Pregunta) it.next();
                        if (auxPregunta.getCategoria() == j+1 && auxPregunta.getNivel_dificultad()==i+1) {
                                   view.buttons[i][j].setText(String.valueOf(auxPregunta.getPuntuacio_pregunta()) + " €");
                        }
                    }
                view.buttons[i][j].addActionListener(this);
            }
        }

        valors_str = model.getStr_categorias();
        for (int i = 0; i < 6; i++) {
            view.categories[i].setText(valors_str[i]);
        }
        
    }
    public void doubleRound(){
    
        LinkedHashSet<Pregunta> auxLinkedHashSet = model.all_questions;
        Pregunta auxPregunta;
         Iterator it = auxLinkedHashSet.iterator();
                    while (it.hasNext()) {
                        auxPregunta = (Pregunta) it.next();
                        auxPregunta.setPuntuacio_pregunta(auxPregunta.getPuntuacio_pregunta()*2);
                                model.all_questions.remove(it);
                                model.all_questions.add(auxPregunta);
                                
                        }                   
                    
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton buttonSelected = (JButton) actionEvent.getSource();
        LinkedHashSet<Pregunta> auxLinkedHashSet = model.all_questions;
        Pregunta auxPregunta;   
        
        
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (buttonSelected == view.buttons[i][j]) {
                    view.buttons[i][j].setEnabled(false);
                    Iterator it = auxLinkedHashSet.iterator();
                    while (it.hasNext()) {
                        auxPregunta = (Pregunta) it.next();
                        if (auxPregunta.getCategoria() == j+1 && auxPregunta.getNivel_dificultad()==i+1) {
                            JeoQuestions view2 = new JeoQuestions();
                            JeoQuestionsModel model = new JeoQuestionsModel(auxPregunta,this.model.getJugador(),view.player1Info,view.player2Info);
                            JeoQuestionsController controller = new  JeoQuestionsController(model,view2);                            
                        }
                    }

                }
            }

        }
        
        model.turno++;   
        if(model.turno==5){
            doubleRound();
            setUpButtons();
        }
        else if(model.turno==7){
            Jugador auxJugador;
                PodiumView view = new PodiumView();
                if(model.jugador1.getPuntuation()>model.jugador2.getPuntuation()){
                auxJugador = model.jugador1;
                }else{
                auxJugador = model.jugador2;
                }                
                PodiumModel modelo = new PodiumModel(auxJugador);
                PodiumController controller = new PodiumController(view,modelo);
            
            
        }
       
    }
}
