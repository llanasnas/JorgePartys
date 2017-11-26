/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.JeoQuestionsModel;
import view.JeoQuestions;

/**
 *
 * @author Alumne
 */
public class JeoQuestionsController {
    
    private JeoQuestions view ;
    private JeoQuestionsModel model;

    public JeoQuestionsController(JeoQuestions view, JeoQuestionsModel model) {
        this.view = view;
        this.model = model;
    }
    
    
    
}
