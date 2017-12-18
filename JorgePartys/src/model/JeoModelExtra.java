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
import java.util.HashSet;

/**
 *
 * @author Bertiwi
 */
public class JeoModelExtra {
    public HashSet<PreguntaExtra> extra_questions = new HashSet<>();
    public int turno=1;

    public JeoModelExtra() {
        cargarDatos();
    }
    
    
    
    public void cargarDatos(){
        Path path = Paths.get("preguntesXtra.txt");
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

                for (int i = 2; i < array_dades.length; i++) {
                    hash_respostes.put(i-1, array_dades[i]);
                }

                PreguntaExtra auxPregunta = new PreguntaExtra(Integer.parseInt(array_dades[0]), array_dades[1], hash_respostes);

                extra_questions.add(auxPregunta);
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
