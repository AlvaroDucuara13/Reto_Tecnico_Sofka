/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sofka.RetoTecnico;

/**
 *
 * @author alvaro
 */
public class Respuesta {

    private String respuesta;
    private boolean correcta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return respuesta;
    }

}
