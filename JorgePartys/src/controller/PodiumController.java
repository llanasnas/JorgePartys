/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Jugador;
import model.PodiumModel;
import view.PodiumView;

/**
 *
 * @author Susana
 */
public class PodiumController {
    
    
    private PodiumView view;
    private PodiumModel model;

    public PodiumController(PodiumView view, PodiumModel model) {
        this.view = view;
        this.model = model;
        setUpData();
    }

    private void setUpData() {
        Jugador auxJugador = model.jugador;  
        view.playerInfo.setText(auxJugador.getNickname());
        view.playerPoints.setText(String.valueOf(auxJugador.getPuntuation() + " €"));
        
    }
    
    
    
    
}
