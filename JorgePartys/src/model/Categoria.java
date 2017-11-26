package model;

import java.util.ArrayList;

public class Categoria {

    private String nombre_categoria;
    private ArrayList<Pregunta> list;

    public Categoria(String nombre_categoria, ArrayList<Pregunta> list) {
        this.nombre_categoria = nombre_categoria;
        this.list = list;
    }

    public void setList(ArrayList<Pregunta> list) {
        this.list = list;
    }

    public Pregunta getPregunta(int points) {

        for (Pregunta p : this.list) {
            if (points == p.getPuntuacion()) {
                return p;
            }
        }
        return null;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public ArrayList<Pregunta> getList() {
        return list;
    }

}
