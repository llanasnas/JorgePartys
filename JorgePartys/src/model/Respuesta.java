package model;

public class Respuesta {
    private String respuesta;
    private boolean esCorrecta;

    public Respuesta(String respuesta, boolean esCorrecta) {
        this.respuesta = respuesta;
        this.esCorrecta = esCorrecta;
    }    

    public String getRespuesta() {
        return respuesta;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    
}
