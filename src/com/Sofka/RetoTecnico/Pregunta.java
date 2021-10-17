/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sofka.RetoTecnico;

import listaDinamica.ListaDinamica;

/**
 *
 * @author alvaro
 */
public class Pregunta {

    private String pregunta;
    private ListaDinamica<Respuesta> respuestas;
    private int puntos;

    public Pregunta(String pregunta, ListaDinamica<Respuesta> respuestas, int puntos) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.puntos = puntos;
    }

    public String getPregunta() {
        return pregunta;
    }

    public ListaDinamica<Respuesta> getRespuestas() {
        return respuestas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void mostrarPregunta() {
        System.out.println(pregunta);

        int i = 0;
        while (i < respuestas.size()) {
            System.out.println("\t" + (i + 1) + ", " + respuestas.get(i));
            i++;
        }
    }

    public boolean comprobarRespuesta(int respuesta) {
        Respuesta Rp = respuestas.get(respuesta - 1);

        if (Rp != null) {
            return Rp.isCorrecta();
        }
        return false;
    }

}
