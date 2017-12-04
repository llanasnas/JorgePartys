/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alumne
 */
public class JeoGUI extends JFrame {

    public JButton[] categories = new JButton[6];
    public JButton[][] buttons = new JButton[5][6];
    public JLabel player1Info = new JLabel();
    public JLabel player2Info = new JLabel();
    
    

    public JeoGUI() {

        this.setTitle("Jeopardy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(this.getContentPane());
        this.setResizable(false);
        this.pack();
        this.setVisible(true);

    }

    public void addComponentsToPane(Container pane) {

        JPanel p = new JPanel();

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        //creem les imatges png dels jugadors
        JLabel player1 = new JLabel();
        JLabel player2 = new JLabel();
        

        ImageIcon icon = new ImageIcon("pg.png");
        player1.setIcon(icon);
        ImageIcon icon2 = new ImageIcon("pg.png");
        player2.setIcon(icon2);
        

        JPanel panel1 = new JPanel(new FlowLayout());

        panel1.setBackground(new Color(52, 168, 116));

        panel1.add(player1Info);        
        panel1.add(player2Info, FlowLayout.CENTER);
        panel1.add(player1, FlowLayout.LEFT);
        panel1.add(player2, FlowLayout.RIGHT);

        p.add(panel1);
        pane.add(p, BorderLayout.NORTH);


        JPanel y = new JPanel();
        y.setLayout(new FlowLayout());

        for (int i = 0; i < 6; i++) {
            categories[i]=new JButton();
            categories[i].setBackground(new Color(168, 52, 161));
            categories[i].setOpaque(true);
            categories[i].setPreferredSize(new Dimension(90, 60));
            categories[i].setEnabled(false);
            categories[i].setFont(new Font("Arial", Font.PLAIN, 12));
            categories[i].setBorder(BorderFactory.createLineBorder(Color.gray));

            y.add(categories[i]);

        }
        y.setBackground(new Color(168, 52, 161));
        pane.add(y, BorderLayout.CENTER);

        JPanel x = new JPanel();

        x.setLayout(new GridLayout(5, 6));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {

                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(90, 60));
                buttons[i][j].setBackground(new Color(255, 110, 0));
                buttons[i][j].setOpaque(true);
                x.add(buttons[i][j]);
            }
        }




        x.setBackground(new Color(255, 110, 0));
        pane.add(x, BorderLayout.SOUTH);

    }

}
