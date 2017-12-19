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
import view.JeoQuestions;

/**
 *
 * @author Susana
 */
public class JeoQuestionsController implements ActionListener {

    private Pregunta model;
    private JeoQuestions view;
    private JeoController controller;

    public JeoQuestionsController(Pregunta pregunta, JeoQuestions view,JeoController controller) {
        this.model = pregunta;
        this.view = view;
        this.controller= controller;
        setUpButtons();
    }

    public void setUpButtons() {

        
        HashMap auxMap = this.model.getRespuestas_posibles();
        view.pregunta.setText(this.model.getPregunta_texto());
        view.opcio1.setText((String) auxMap.get(1));
        view.opcio2.setText((String) auxMap.get(2));
        view.opcio3.setText((String) auxMap.get(3));
        view.opcio1.addActionListener(this);
        view.opcio2.addActionListener(this);
        view.opcio3.addActionListener(this);        
        controller.disableButton(model);        
        
    }

    public void actionPerformed(ActionEvent actionEvent) {
        JButton buttonSelected = (JButton) actionEvent.getSource();        
        HashMap auxMap = this.model.getRespuestas_posibles();
        controller.enableButtons();
        
        
            if (buttonSelected.getText().equals(auxMap.get(this.model.getRespuesta_correcta()))) {
            view.dispose();
            JOptionPane.showMessageDialog(null, "Correcto"); 
            controller.preguntaAcertada(model.getPuntuacio_pregunta());
            controller.preguntaRespondida();    
        } else {
            view.dispose();
            JOptionPane.showMessageDialog(null, " Incorrecto \n La respuesta correcta era: \n " + auxMap.get(this.model.getRespuesta_correcta()));
            controller.preguntaFallida(model.getPuntuacio_pregunta()); 
            controller.preguntaRespondida();

        }
        }

    }


