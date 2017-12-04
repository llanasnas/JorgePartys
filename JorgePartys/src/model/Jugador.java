package model;

public class Jugador {

    private String nickname;
    private int puntuation;
    private int correct_answer;
    private int failed_answer;

    public Jugador() {
    }

    public Jugador(String nickname) {
        this.nickname = nickname;
        this.puntuation = 0;
        this.correct_answer = 0;
        this.failed_answer = 0;
    }

    public String getNickname() {
        return nickname;
    }

    public int getPuntuation() {
        return puntuation;
    }

    public int getCorrect_answer() {
        return correct_answer;
    }

    public int getFailed_answer() {
        return failed_answer;
    }

    public void restarPuntuacion(int valor) {
        this.puntuation = -valor;
    }

    public void sumarPuntuacion(int valor) {
        this.puntuation = +valor;
    }

    public void preguntaAcertada() {
        this.correct_answer++;
    }

    public void preguntaFallada() {

        this.failed_answer++;
    }
}
