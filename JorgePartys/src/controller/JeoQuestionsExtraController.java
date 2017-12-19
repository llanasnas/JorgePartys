/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.JeoModelExtra;
import model.Jugador;
import model.PodiumModel;
import model.PreguntaExtra;
import view.JeoQuestions;
import view.PodiumView;

/**
 *
 * @author Bertiwi
 */
public class JeoQuestionsExtraController implements ActionListener {

    private JeoModelExtra model;
    private JeoQuestions view;
    private JeoController controller;

    public JeoQuestionsExtraController(JeoModelExtra model, JeoQuestions view, JeoController controller) {
        this.model = model;
        this.view = view;
        this.controller = controller;
        setUpButtons();
    }

    public PreguntaExtra getPregunta() {
        int i = model.turno;
        PreguntaExtra pregunta = model.extra_questions.get(i);
        return pregunta;
    }

    public void preguntaRespuesta() {
        if (model.turno+1 == 10) {
            if(model.acertado1&&model.acertado2){
            JOptionPane.showMessageDialog(null, "EMPATE");
            }else if (model.acertado1 == true && model.acertado2 == false) {
                Jugador auxJugador;
                PodiumView view = new PodiumView();
                auxJugador = controller.model.jugador1;
                PodiumModel modelo = new PodiumModel(auxJugador);
                PodiumController controller = new PodiumController(view, modelo);
                this.view.dispose();
            } else if (model.acertado1 == false && model.acertado2 == true) {
                Jugador auxJugador;
                PodiumView view = new PodiumView();
                auxJugador = controller.model.jugador2;
                PodiumModel modelo = new PodiumModel(auxJugador);
                PodiumController controller = new PodiumController(view, modelo);
                this.view.dispose();
            }
        } else if (model.turno % 2 == 0) {
            model.turno++;
            if (model.acertado1 == true && model.acertado2 == true || model.acertado1 == false && model.acertado2 == false) {
                PreguntaExtra pregunta = getPregunta();
                HashMap auxMap = pregunta.getRespuestas_posibles();
                view.pregunta.setText(pregunta.getPregunta_extra());
                view.opcio1.setText((String) auxMap.get(1));
                view.opcio2.setText((String) auxMap.get(2));
                view.opcio3.setText((String) auxMap.get(3));
            } else if (model.acertado1 == true && model.acertado2 == false) {
                Jugador auxJugador;
                PodiumView view = new PodiumView();
                auxJugador = controller.model.jugador1;
                PodiumModel modelo = new PodiumModel(auxJugador);
                PodiumController controller = new PodiumController(view, modelo);
                this.view.dispose();
            } else if (model.acertado1 == false && model.acertado2 == true) {
                Jugador auxJugador;
                PodiumView view = new PodiumView();
                auxJugador = controller.model.jugador2;
                PodiumModel modelo = new PodiumModel(auxJugador);
                PodiumController controller = new PodiumController(view, modelo);
                this.view.dispose();
            }

        } else {
            model.turno++;
            PreguntaExtra pregunta = getPregunta();
            HashMap auxMap = pregunta.getRespuestas_posibles();
            view.pregunta.setText(pregunta.getPregunta_extra());
            view.opcio1.setText((String) auxMap.get(1));
            view.opcio2.setText((String) auxMap.get(2));
            view.opcio3.setText((String) auxMap.get(3));

        }

    }

    public void setUpButtons() {
        PreguntaExtra pregunta = getPregunta();
        HashMap auxMap = pregunta.getRespuestas_posibles();
        view.pregunta.setText(pregunta.getPregunta_extra());
        view.opcio1.setText((String) auxMap.get(1));
        view.opcio2.setText((String) auxMap.get(2));
        view.opcio3.setText((String) auxMap.get(3));
        view.opcio1.addActionListener(this);
        view.opcio2.addActionListener(this);
        view.opcio3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        JButton buttonSelected = (JButton) actionEvent.getSource();
        PreguntaExtra pregunta = getPregunta();
        HashMap auxMap = pregunta.getRespuestas_posibles();
        controller.enableButtons();

        if (buttonSelected.getText().equals(auxMap.get(pregunta.getRespuesta_correcta()))) {

            JOptionPane.showMessageDialog(null, "Correcto");
            //controller.preguntaAcertada(model.getPuntuacio_pregunta());

            if (model.turno % 2 == 0) {
                model.acertado2 = true;
                JOptionPane.showMessageDialog(null, "Jugador 1:");
            } else {
                model.acertado1 = true;
                JOptionPane.showMessageDialog(null, "Jugador 2:");
            }
            preguntaRespuesta();
        } else {
            JOptionPane.showMessageDialog(null, " Incorrecto \n La respuesta correcta era: \n " + auxMap.get(pregunta.getRespuesta_correcta()));
            //controller.preguntaFallida(model.getPuntuacio_pregunta()); 

            if (model.turno % 2 == 0) {
                model.acertado2 = false;
                JOptionPane.showMessageDialog(null, "Jugador 1:");
            } else {
                model.acertado1 = false;
                JOptionPane.showMessageDialog(null, "Jugador 2:");
            }
            preguntaRespuesta();
        }

    }
}
