/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sofka.RetoTecnico;

import Leer.Leer;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author alvaro
 * la clase Juego_Preguntas_Respuestas contiene el metodo main
 */
public class Juego_Preguntas_Respuestas {

    public static void main(String[] args) {

        Test t = new Test();
        try {
            t.cargarFichero("preguntas-categoria1.txt");
            t.cargarFichero2("preguntas-categoria2.txt");
            t.cargarFichero3("preguntas-categoria3.txt");
            t.cargarFichero4("preguntas-categoria4.txt");
            t.cargarFichero5("preguntas-categoria5.txt");
            
            //t.setName(JOptionPane.showInputDialog(null,"Como es su nombre"));
            Leer Entrada = new Leer();
            String Jugador = Entrada.pedirString("Nombre Jugador: ");
            t.setName(Jugador);
               
            t.Categoria1();
            t.Categoria2();
            t.Categoria3();
            t.Categoria4();
            t.Categoria5();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

}
