/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Pregunta;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import classes.RoundedBorder;
import java.awt.BorderLayout;
import java.awt.Color;


/**
 *
 * @author Susana
 */
public class JeoQuestions extends JFrame {

    public JButton opcio1, opcio2, opcio3;
    public JLabel pregunta;
    public JPanel p1, p2;

    public JeoQuestions() {

        this.setTitle("Jeopardy");        
        addComponentsToPane(this.getContentPane());
        this.setResizable(true);
        this.pack();
        this.setVisible(true);

    }

    private void addComponentsToPane(Container pane) {

        pane.setSize(new Dimension(500,500));
        
        p1=new JPanel();
        p2=new JPanel();        
        pregunta = new JLabel("Aqui va la pregunta");
        pregunta.setSize(new Dimension(400, 50));
        pregunta.setOpaque(true);             
        p1.add(pregunta,BorderLayout.CENTER);   
        p1.setSize(new Dimension(100,100));
        p2.setLayout(new BorderLayout(400, 70));
        opcio1 = new JButton("Opcio 1");
        opcio1.setPreferredSize(new Dimension(250, 50));
        opcio1.setBorder(new RoundedBorder(50));        
        opcio1.setOpaque(true);
        
        opcio2 = new JButton("Opcio 2");
        opcio2.setPreferredSize(new Dimension(250, 50));
        opcio2.setBorder(new RoundedBorder(50));
        opcio2.setOpaque(true);

        opcio3 = new JButton("Opcio 3");
        opcio3.setPreferredSize(new Dimension(250, 50));
        opcio3.setBorder(new RoundedBorder(50));
        opcio3.setOpaque(true);
               
       
        p2.add(opcio1,BorderLayout.NORTH);
        p2.add(opcio2,BorderLayout.CENTER);
        p2.add(opcio3,BorderLayout.SOUTH);
        pane.add(p1,BorderLayout.NORTH);
        pane.add(p2,BorderLayout.CENTER);
        
    }

}
