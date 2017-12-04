/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pregunta;
import model.Respuesta;
import java.util.ArrayList;
import model.JeoQuestionsModel;
import view.JeoQuestions;

/**
 *
 * @author Susana
 */
public class JeoQuestionsController {

    private JeoQuestionsModel model;
    private JeoQuestions view;

    public JeoQuestionsController(JeoQuestionsModel model, JeoQuestions view) {
        this.model = model;
        this.view = view;
        setUpButtons();
    }

    public void setUpButtons() {
       
    }
    
    
}
