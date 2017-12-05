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
    public JeoModel model;

    public JeoController(JeoGUI view, JeoModel model) {
        this.view = view;
        this.model = model;
        setUpButtons();
    }

    public void setUpButtons() {
        view.player1Info.setText(String.valueOf(model.jugador1.getNickname() + ": " + model.jugador1.getPuntuation()));
        view.player2Info.setText(String.valueOf(model.jugador2.getNickname() + ": " + model.jugador2.getPuntuation()));
        String[] valors_str = model.getPreu_preguntes();
        LinkedHashSet<Pregunta> auxLinkedHashSet = model.all_questions;
        Pregunta auxPregunta;
        for (int i = 0; i < 5; i++) {
//            this.view.buttons[i-1]=new JButton();
            for (int j = 0; j < 6; j++) {
                Iterator it = auxLinkedHashSet.iterator();
                while (it.hasNext()) {
                    auxPregunta = (Pregunta) it.next();
                    if (auxPregunta.getCategoria() == j + 1 && auxPregunta.getNivel_dificultad() == i + 1) {
                        view.buttons[i][j].setText(String.valueOf(auxPregunta.getPuntuacio_pregunta()) + " €");
                    }
                }
                if (!model.actionListenerActivated) {
                    view.buttons[i][j].addActionListener(this);
                }
            }
        }
        model.actionListenerActivated = true;

        valors_str = model.getStr_categorias();
        for (int i = 0; i < 6; i++) {
            view.categories[i].setText(valors_str[i]);
        }

    }

    public void doubleRound() {

        LinkedHashSet<Pregunta> auxLinkedHashSet = model.all_questions;
        Pregunta auxPregunta;
        Iterator it = auxLinkedHashSet.iterator();
        while (it.hasNext()) {
            auxPregunta = (Pregunta) it.next();
            auxPregunta.setPuntuacio_pregunta(auxPregunta.getPuntuacio_pregunta() * 2);
            model.all_questions.remove(it);
            model.all_questions.add(auxPregunta);

        }

    }

    public void preguntaRespondida() {

        view.player1Info.setText(String.valueOf(model.jugador1.getNickname() + ": " + model.jugador1.getPuntuation()));
        view.player2Info.setText(String.valueOf(model.jugador2.getNickname() + ": " + model.jugador2.getPuntuation()));
        model.turno++;
        if (model.turno == 5) {
            doubleRound();
            JOptionPane.showMessageDialog(null, "Habeis llegado a la JeoPardy Double Round");
            setUpButtons();
        } else if (model.turno == 7) {
            Jugador auxJugador;
            PodiumView view = new PodiumView();
            if (model.jugador1.getPuntuation() > model.jugador2.getPuntuation()) {
                auxJugador = model.jugador1;
            } else {
                auxJugador = model.jugador2;
            }
            PodiumModel modelo = new PodiumModel(auxJugador);
            PodiumController controller = new PodiumController(view, modelo);
        }

    }

    public void preguntaAcertada(int valor) {
        model.getJugador().preguntaAcertada();
        model.getJugador().sumarPuntuacion(valor);

    }

    public void disableButton(Pregunta p) {
        Pregunta auxPregunta;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (p.getCategoria() - 1 == j && p.getNivel_dificultad() - 1 == i) {
                    view.buttons[i][j].setEnabled(false);
                }
            }
        }
        

    }
    public void enableButton(Pregunta p) {
        Pregunta auxPregunta;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (p.getCategoria() - 1 == j && p.getNivel_dificultad() - 1 == i) {
                    view.buttons[i][j].setEnabled(false);
                }
            }
        }

    }

    public void preguntaFallida(int valor) {
        model.getJugador().preguntaFallada();
        model.getJugador().restarPuntuacion(valor);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton buttonSelected = (JButton) actionEvent.getSource();
        LinkedHashSet<Pregunta> auxLinkedHashSet = model.all_questions;
        Pregunta auxPregunta;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (buttonSelected == view.buttons[i][j]) {
                    Iterator it = auxLinkedHashSet.iterator();
                    while (it.hasNext()) {
                        auxPregunta = (Pregunta) it.next();
                        if (auxPregunta.getCategoria() == j + 1 && auxPregunta.getNivel_dificultad() == i + 1) {
                            JeoQuestions view2 = new JeoQuestions();

                            JeoQuestionsController controller = new JeoQuestionsController(auxPregunta, view2, this);
                        }
                    }

                }
            }

        }

    }
}
