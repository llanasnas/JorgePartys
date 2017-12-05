/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import clases.RoundedBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

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
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Seguro que quieres cerrar?", "Estás seguro?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        JeoQuestions.this.dispose();
                        
                }
            }
        });

    }

    private void addComponentsToPane(Container pane) {

        p1 = new JPanel();
        p2 = new JPanel();
        pregunta = new JLabel("Aqui va la pregunta");
        pregunta.setOpaque(true);
        pregunta.setBackground(new Color(255, 110, 0));
        p1.add(pregunta, BorderLayout.CENTER);
        p1.setSize(new Dimension(100, 100));
        p2.setLayout(new BorderLayout());
        p1.setBackground(new Color(255, 110, 0));
        p2.setBackground(new Color(255, 110, 0));
        opcio1 = new JButton("Opcio 1");
        opcio1.setPreferredSize(new Dimension(600, 50));
        opcio1.setBorder(new RoundedBorder(50));
        opcio1.setOpaque(true);
        opcio1.setBackground(new Color(255, 110, 0));
        p1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        p2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        opcio2 = new JButton("Opcio 2");
        opcio2.setPreferredSize(new Dimension(600, 50));
        opcio2.setBorder(new RoundedBorder(50));
        opcio2.setOpaque(true);
        opcio2.setBackground(new Color(255, 110, 0));
        opcio3 = new JButton("Opcio 3");
        opcio3.setPreferredSize(new Dimension(600, 50));
        opcio3.setBorder(new RoundedBorder(50));
        opcio3.setOpaque(true);
        opcio3.setBackground(new Color(255, 110, 0));

        p2.add(opcio1, BorderLayout.NORTH);
        p2.add(opcio2, BorderLayout.CENTER);
        p2.add(opcio3, BorderLayout.SOUTH);
        pane.add(p1, BorderLayout.NORTH);
        pane.add(p2, BorderLayout.CENTER);

    }

}
