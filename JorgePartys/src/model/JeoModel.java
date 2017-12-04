/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author Alumne
 */
public class JeoModel {

    private String[] str_categorias = {"CIENCIA", "HISTORIA", "ARTE", "DEPORTE", "CINE", "GEOGRAFIA"};
    private String[] preu_preguntes = {"100€", "200€", "300€", "400€", "500€"};
    public Jugador jugador1;
    public LinkedHashSet<Pregunta> all_questions = new LinkedHashSet<>();
    public Jugador jugador2;
    public int turno=1;

    public JeoModel() {
        this.jugador1 = new Jugador("Jugador 1");
        this.jugador2 = new Jugador("Jugador 2");
        cargarDatos();
    }
    public Jugador getJugador(){
    
        if(turno%2==0){
            return this.jugador2;
        }else{
            return this.jugador1;
        }
        
    }

    public String[] getStr_categorias() {
        return str_categorias;
    }

    public String[] getPreu_preguntes() {
        return preu_preguntes;
    }

    public void cargarDatos(){
        Path path = Paths.get("datosprueba.txt");
        BufferedReader br = null;
        
        String[] array_dades ;
        String linea=null;
        try {
            br = Files.newBufferedReader(path, java.nio.charset.StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("No se ha podido leer el fichero");;
        }
        try {
            
            while ((linea = br.readLine()) != null) {
                array_dades = linea.split(";");
                HashMap<Integer,String> hash_respostes = new HashMap<>();

                for (int i = 5; i < array_dades.length; i++) {
                    hash_respostes.put(i-4, array_dades[i]);
                }

                Pregunta auxPregunta = new Pregunta(Integer.parseInt(array_dades[0]), Integer.parseInt(array_dades[1]), Integer.parseInt(array_dades[2]), Integer.parseInt(array_dades[3]), array_dades[4], hash_respostes);

                all_questions.add(auxPregunta);
            }            
        } catch (IOException e) {
            System.out.println("No se ha podido leer");
        } finally {
            try {
                if(br!=null){
                br.close();
                }
            } catch (IOException e) {
                System.out.println("No se ha podido cerrar el archivo");
            }
        }
    }
}
/* ArrayList<Categoria>
 */
//CIENCIA 1
//HISTORIA 2
//ARTE 3
//DEPORTE 4
//CINE 5
//GEOGRAFIA 6