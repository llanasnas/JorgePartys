/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.JeoGUI;

/**
 *
 * @author Alumne
 */
public class JeoController {
     private JeoGUI view ;
    private JeoController controller;

    public JeoController(JeoGUI view, JeoController controller) {
        this.view = view;
        this.controller = controller;
    }
    
    
}
