/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Alumne
 */
public class JeoModel {

    private String[] ct = {"CIENCIA", "HISTORIA", "ARTE", "DEPORTE", "CINE", "GEOGRAFIA"};
    private String[] valors = {"100", "200", "300", "400", "500"};
    public ArrayList<Categoria> categorias;
    public Jugador jugador1;
    public Jugador jugador2;

    public JeoModel() throws IOException {
        this.jugador1 = new Jugador("jugador 1;");
        this.jugador2 = new Jugador("jugador 2");
        cargarDatos();
    }

    public String[] getCt() {
        return ct;
    }

    public String[] getValors() {
        return valors;
    }

    public void cargarDatos() throws FileNotFoundException, IOException {

        //Aquest metode creara preguntes amb les seves respostes, i categories amb les seves preguntes, i despres un cop fet el arrayList de categories l'afegirem al array de la classe
        FileReader fwEntrada = new FileReader("preguntes.dat");
        BufferedReader brEntrada = new BufferedReader(fwEntrada);
        ArrayList<Categoria> categorias = new ArrayList();
        ArrayList<Respuesta> respostes = new ArrayList();
        ArrayList<Pregunta> listaPreguntas = new ArrayList();
        HashMap<String, Pregunta> preguntes = new HashMap();
        String line = brEntrada.readLine();
        String[] lineP = null;
        int position = 10;
        Respuesta resp;
        char c;
        boolean correct = false, creat = false;
        while (line != null) {

            lineP = line.split(";");
            //Aqui omplim el arraylist de respostes amb las respostes falses o certes
            if (respostes == null) {
                respostes = new ArrayList<Respuesta>();
            }

            for (int i = 0; i < 3; i++) {
                c = lineP[3].charAt(0);
                if (c == '!') {
                    resp = new Respuesta(lineP[3+i], true);
                } else {
                    resp = new Respuesta(lineP[3+i], false);
                }
                respostes.add(resp);
            }
            //i aqui creem la pregunta 
            Pregunta preg = new Pregunta(Integer.parseInt(lineP[1]), lineP[2], respostes);
            respostes = null;
            position++;

            for (String cat : ct) {

                if (lineP[0].equals(cat)) {
                    preguntes.put(lineP[0].concat(String.valueOf(position)), preg);
                }
            }
            line = brEntrada.readLine();
        }
        brEntrada.close();
        fwEntrada.close();
        //aqui usaremos el hashmap para crear rellenar el ArrayList de categorias de la clase       

        this.categorias = new ArrayList();
        for (String cat : ct) {
            position = 0;
            if (listaPreguntas == null) {
                listaPreguntas = new ArrayList<Pregunta>();
            }
            for (String key : preguntes.keySet()) {
                line = key.substring(0, key.length() - 2);
                System.out.println(line);
                if (cat.equals(line)) {

                    listaPreguntas.add(preguntes.get(key));
                    Pregunta aux;
                }
                position++;

            }
            this.categorias.add(new Categoria(cat, listaPreguntas));
            listaPreguntas = null;
        }

    }

}
