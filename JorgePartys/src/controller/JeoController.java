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
        view.player1Info.setText(String.valueOf(model.jugador1.getPuntuation()));
        view.player2Info.setText(String.valueOf(model.jugador2.getPuntuation()));
        String[] valors_str = model.getPreu_preguntes();
        for (int i = 0; i < 5; i++) {
//            this.view.buttons[i-1]=new JButton();
            for (int j = 0; j < 6; j++) {
                switch (i) {
                    case 0:
                        view.buttons[i][j].setText(valors_str[0]);
                        break;
                    case 1:
                        view.buttons[i][j].setText(valors_str[1]);
                        break;
                    case 2:
                        view.buttons[i][j].setText(valors_str[2]);
                        break;
                    case 3:
                        view.buttons[i][j].setText(valors_str[3]);
                        break;
                    case 4:
                        view.buttons[i][j].setText(valors_str[4]);
                        break;
                }
                view.buttons[i][j].addActionListener(this);
            }
        }

        valors_str = model.getStr_categorias();
        for (int i = 0; i < 6; i++) {
            view.categories[i].setText(valors_str[i]);
        }
    }
        @Override
        public void actionPerformed (ActionEvent actionEvent){
            JButton buttonSelected = (JButton) actionEvent.getSource();


        }
    }
