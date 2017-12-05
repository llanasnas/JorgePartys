/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Susana
 */
public class PodiumView extends JFrame {

    public JLabel ganador = new JLabel();
    public JLabel playerInfo = new JLabel();
    public JLabel playerPoints = new JLabel();

    public PodiumView() {

        this.setTitle("Jeopardy");
        
        addComponentsToPane(this.getContentPane());
        this.setResizable(false);
        this.pack();
        this.setVisible(true);

    }

    public void addComponentsToPane(Container pane) {

        JPanel p = new JPanel();

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        ImageIcon icon = new ImageIcon("ganador.png");
        ganador.setIcon(icon);
        p.add(ganador);
        p.setBackground(new Color(52, 168, 116));        
        playerInfo.setForeground(Color.yellow);
        playerInfo.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
        playerPoints.setForeground(Color.yellow);
        playerPoints.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        p.add(playerInfo);
        p.add(playerPoints);

        pane.add(p);

    }

}
