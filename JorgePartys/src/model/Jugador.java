package model;

public class Jugador {
    private String nickname;
    private int puntuation;
    private int correct_answer;
    private int failed_answer;

    public Jugador(String nickname) {
        this.nickname = nickname;
        this.puntuation=0;
        this.failed_answer=0;
        this.correct_answer=0;
    }

    public void restarPuntuacion(){

    }

    public int getPuntuation() {
        return puntuation;
    }

    public void sumarPuntuacion(){

    }

    public void preguntaAcertada(){

    }

    public void preguntaFallada(){

    }
}
