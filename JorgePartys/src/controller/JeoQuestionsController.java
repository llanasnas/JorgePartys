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
    
    
private    JeoQuestionsModel model;
private JeoQuestions view;

    public JeoQuestionsController(JeoQuestionsModel model, JeoQuestions view) {
        this.model = model;
        this.view = view;
        setUpButtons();
    }
    public void setUpButtons(){
    Pregunta p = model.getPregunta();
    Respuesta r;
    char c;
        view.pregunta.setText(p.getPregunta());
        ArrayList<Respuesta> respostes = p.getRespostes();
        for(Respuesta resp : respostes){
            c = resp.getRespuesta().charAt(0);
        if(c=='!'){
        String correcta = resp.getRespuesta();
        correcta = correcta.substring(1,correcta.length());
        resp.setRespuesta(correcta);                
        }
        }
        r=respostes.get(0);
        view.opcio1.setText(r.getRespuesta());
        r=respostes.get(1);
        view.opcio2.setText(r.getRespuesta());
        r=respostes.get(2);
        view.opcio3.setText(r.getRespuesta());
    
    }
}
