/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Categoria;
import model.Pregunta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.JeoQuestionsModel;
import javax.swing.JButton;
import model.JeoModel;
import view.JeoGUI;
import view.JeoQuestions;

/**
 *
 * @author Alumne
 */
public class JeoController implements ActionListener {

    private JeoGUI view;
    private JeoModel model;

    public JeoController(JeoModel model, JeoGUI view) {

        this.model = model;
        this.view = view;
        setUpButtons();

    }

    public void setUpButtons() {

        view.player1Info.setText(String.valueOf(model.jugador1.getPuntuation()));
        view.player2Info.setText(String.valueOf(model.jugador2.getPuntuation()));
        String[] valors = model.getValors();
        for (int i = 0; i < 5; i++) {
//            this.view.buttons[i-1]=new JButton();
            for (int j = 0; j < 6; j++) {
                switch (i) {
                    case 0:
                        view.buttons[i][j].setText(valors[0].concat(" €"));
                        break;
                    case 1:
                        view.buttons[i][j].setText(valors[1].concat(" €"));
                        break;
                    case 2:
                        view.buttons[i][j].setText(valors[2].concat(" €"));
                        break;
                    case 3:
                        view.buttons[i][j].setText(valors[3].concat(" €"));
                        break;
                    case 4:
                        view.buttons[i][j].setText(valors[4].concat(" €"));
                        break;
                }
                view.buttons[i][j].addActionListener(this);
            }
        }
        valors = model.getCt();
        for (int i = 0; i < 6; i++) {
            view.categories[i].setText(valors[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSelected = (JButton) e.getSource();
        JeoQuestionsModel jqm;
        Pregunta p = null;
        Categoria c = null ;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (view.buttons[i][j] == buttonSelected) {
                    view.buttons[i][j].setEnabled(false);
                    switch (j) {
                        case 0:
                            for (Categoria cat : model.categorias) {

                                if (cat.getNombre_categoria().equals("CIENCIA")) {
                                    c = cat;
                                }

                            }
                            switch (i) {

                                case 0:
                                    p = c.getPregunta(100);
                                    
                                    break;
                                case 1:
                                    p = c.getPregunta(200);
                                    
                                    break;
                                case 2:
                                    p = c.getPregunta(300);
                                    break;
                                case 3:
                                    p = c.getPregunta(400);
                                    break;
                                case 4:
                                    p = c.getPregunta(500);
                                    break;

                            }
                            break;
                        case 1:
                            for (Categoria cat : model.categorias) {

                                if (cat.getNombre_categoria().equals("HISTORIA")) {
                                    c = cat;
                                }

                            }                           
                            
                            switch (i) {

                                case 0:
                                    p = c.getPregunta(100);
                                    
                                    break;
                                case 1:
                                    p = c.getPregunta(200);
                                    
                                    break;
                                case 2:
                                    p = c.getPregunta(300);
                                    break;
                                case 3:
                                    p = c.getPregunta(400);
                                    break;
                                case 4:
                                    p = c.getPregunta(500);
                                    break;

                            }
                            break;
                        case 2:
                            for (Categoria cat : model.categorias) {

                                if (cat.getNombre_categoria().equals("ARTE")) {
                                    c = cat;
                                }

                            }                           
                            
                            switch (i) {

                                case 0:
                                    p = c.getPregunta(100);
                                    
                                    break;
                                case 1:
                                    p = c.getPregunta(200);
                                    
                                    break;
                                case 2:
                                    p = c.getPregunta(300);
                                    break;
                                case 3:
                                    p = c.getPregunta(400);
                                    break;
                                case 4:
                                    p = c.getPregunta(500);
                                    break;

                            }
                            break;
                        case 3:
                            for (Categoria cat : model.categorias) {

                                if (cat.getNombre_categoria().equals("DEPORTE")) {
                                    c = cat;
                                }

                            }
                            switch (i) {

                                case 0:
                                    p = c.getPregunta(100);
                                    
                                    break;
                                case 1:
                                    p = c.getPregunta(200);
                                    
                                    break;
                                case 2:
                                    p = c.getPregunta(300);
                                    break;
                                case 3:
                                    p = c.getPregunta(400);
                                    break;
                                case 4:
                                    p = c.getPregunta(500);
                                    break;

                            }
                            break;
                        case 4:
                            for (Categoria cat : model.categorias) {

                                if (cat.getNombre_categoria().equals("CINE")) {
                                    c = cat;
                                }

                            }
                            switch (i) {

                                case 0:
                                    p = c.getPregunta(100);
                                    
                                    break;
                                case 1:
                                    p = c.getPregunta(200);
                                    
                                    break;
                                case 2:
                                    p = c.getPregunta(300);
                                    break;
                                case 3:
                                    p = c.getPregunta(400);
                                    break;
                                case 4:
                                    p = c.getPregunta(500);
                                    break;

                            }
                            break;
                        case 5:
                            for (Categoria cat : model.categorias) {

                                if (cat.getNombre_categoria().equals("GEOGRAFIA")) {
                                    c = cat;
                                }

                            }
                            switch (i) {

                                case 0:
                                    p = c.getPregunta(100);
                                    
                                    break;
                                case 1:
                                    p = c.getPregunta(200);
                                    
                                    break;
                                case 2:
                                    p = c.getPregunta(300);
                                    break;
                                case 3:
                                    p = c.getPregunta(400);
                                    break;
                                case 4:
                                    p = c.getPregunta(500);
                                    break;

                            }
                            break;

                    }
                    jqm = new JeoQuestionsModel(p);
                    JeoQuestions jeoQuestionsView = new JeoQuestions();
                    JeoQuestionsController jeoQuestionsControler = new JeoQuestionsController(jqm,jeoQuestionsView);
                }
            }
        }
    }

}
