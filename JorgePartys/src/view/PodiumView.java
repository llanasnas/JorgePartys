/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
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
    public JLabel playerInfo = new JLabel(" ",JLabel.CENTER);
    public JLabel playerPoints = new JLabel(" ",JLabel.CENTER);

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
        JLabel winnerIs = new JLabel(" GANADOR: ",JLabel.CENTER);
        winnerIs.setForeground(Color.yellow);
        winnerIs.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        winnerIs.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        p.add(winnerIs);
        ImageIcon icon = new ImageIcon("ganador.png");
        ganador.setIcon(icon);
        ganador.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        p.add(ganador);
        p.setBackground(new Color(52, 168, 116));        
        playerInfo.setForeground(Color.yellow);
        playerInfo.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        playerInfo.setHorizontalAlignment(JLabel.CENTER);
        playerInfo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        playerPoints.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        playerPoints.setForeground(Color.yellow);
        playerPoints.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        playerInfo.setHorizontalAlignment(JLabel.CENTER);
        p.add(playerInfo);
        p.add(playerPoints);

        pane.add(p);

    }

}
