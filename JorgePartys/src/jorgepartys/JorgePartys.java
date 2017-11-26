/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgepartys;

import model.Categoria;
import model.Pregunta;
import model.Respuesta;
import view.JeoGUI;
import controller.JeoController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import model.JeoModel;

/**
 *
 * @author Alumne
 */
public class JorgePartys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        JeoGUI view = new JeoGUI();
        JeoModel model = new JeoModel();
        JeoController controller = new JeoController(model, view);
    }

}
