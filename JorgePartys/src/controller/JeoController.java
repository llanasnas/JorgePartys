/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.JeoModel;
import view.JeoGUI;

/**
 *
 * @author Alumne
 */
public class JeoController {
     private JeoGUI view ;
    private JeoModel model;

    public JeoController(JeoGUI view, JeoModel controller) {
        this.view = view;
        this.model = controller;
    }
    
    
    
}
