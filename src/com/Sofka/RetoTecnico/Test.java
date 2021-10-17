/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sofka.RetoTecnico;

import Leer.Leer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import listaDinamica.ListaDinamica;

/**
 *
 * @author alvaro
 * la clase Test se realiza la configuracion del juego, asi como tambien, se carga los datos de cada pregunta y respuesta, y se guarda el historial del jugador
 */
public class Test {

    //atributos
    ListaDinamica<Pregunta> preguntas;
    ListaDinamica<Pregunta> preguntas2;
    ListaDinamica<Pregunta> preguntas3;
    ListaDinamica<Pregunta> preguntas4;
    ListaDinamica<Pregunta> preguntas5;
    private int puntosTotales;
    private int preguntaActual;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Constructor
    public Test() {
        preguntas = new ListaDinamica<>();
        preguntas2 = new ListaDinamica<>();
        preguntas3 = new ListaDinamica<>();
        preguntas4 = new ListaDinamica<>();
        preguntas5 = new ListaDinamica<>();
        puntosTotales = 0;
        preguntaActual = 0;
    }

    public ListaDinamica<Pregunta> getPreguntas4() {
        return preguntas4;
    }

    public ListaDinamica<Pregunta> getPreguntas5() {
        return preguntas5;
    }

    public ListaDinamica<Pregunta> getPreguntas3() {
        return preguntas3;
    }

    //Getter
    public ListaDinamica<Pregunta> getPreguntas() {
        return preguntas;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public ListaDinamica<Pregunta> getPreguntas2() {
        return preguntas2;
    }

    public int getPreguntaActual() {
        return preguntaActual;
    }

    public void Categoria1() {

        //si estan vacias las preguntas, no hacemos nada
        if (!preguntas.isEmpty()) {
            Scanner Entrada2 = new Scanner(System.in);
            System.out.println("Deseas Empezar la primera ronda? \nEscriba 'si' para continuar");
            String Dec2 = Entrada2.nextLine();
            if (Dec2.equals("si") | Dec2.equals("Si") | Dec2.equals("SI")) {

                //Creamos un objeto leer
                Leer teclado = new Leer();

                int i = 0, respuesta;
                Pregunta p;

                //recorremos las preguntas
                int A = (int) (Math.random() * 5);

                //Cojemos una pregunta
                p = preguntas.get(A);

                //La mostramos
                p.mostrarPregunta();

                //Pedimos una respuesta
                respuesta = teclado.pedirIntRango(1, p.getRespuestas().size(), "Introduce el numero que representa la respuesta ");

                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta)) {
                    System.out.println("Has acertado" + " " + p.getPuntos() + "  puntos");
                    puntosTotales += p.getPuntos();
                    System.out.println("Puntos Acumulados: " + puntosTotales);
                    preguntas = new ListaDinamica<>();
                    this.guardarJugador();

                } else {

                    puntosTotales = 0;
                    preguntas = new ListaDinamica<>();
                    preguntas2 = new ListaDinamica<>();
                    preguntas3 = new ListaDinamica<>();
                    preguntas4 = new ListaDinamica<>();
                    preguntas5 = new ListaDinamica<>();

                    System.out.println("Respuesta Incorrecta, Fin del juego");
                    this.guardarJugador();
                }

            } else {
                preguntas = new ListaDinamica<>();
                preguntas2 = new ListaDinamica<>();
                preguntas3 = new ListaDinamica<>();
                preguntas4 = new ListaDinamica<>();
                preguntas5 = new ListaDinamica<>();
                System.out.println("Fin del Juego, has conseguido: " + puntosTotales + " Puntos");
                this.guardarJugador();

            }
        }

    }

    public void Categoria2() {

        if (!preguntas2.isEmpty()) {
            Scanner Entrada2 = new Scanner(System.in);
            System.out.println("Quiere Seguir a la segunda ronda?");
            String Dec2 = Entrada2.nextLine();
            //si estan vacias las preguntas, no hacemos nada
            if (Dec2.equals("si")) {
                //Creamos un objeto leer
                Leer teclado = new Leer();

                int i = 0, respuesta2;
                Pregunta p;

                //recorremos las preguntas
                int A = (int) (Math.random() * 5);

                //Cojemos una pregunta
                p = preguntas2.get(A);

                //La mostramos
                p.mostrarPregunta();

                //Pedimos una respuesta
                respuesta2 = teclado.pedirIntRango(1, p.getRespuestas().size(), "Introduce el numero que representa la respuesta");

                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta2)) {
                    System.out.println("Has acertado" + " " + p.getPuntos() + "  puntos");
                    puntosTotales += p.getPuntos();
                    System.out.println("Puntos Acumulados: " + puntosTotales);
                    preguntas2 = new ListaDinamica<>();
                    this.guardarJugador();

                } else {

                    puntosTotales = 0;
                    preguntas2 = new ListaDinamica<>();
                    preguntas3 = new ListaDinamica<>();
                    preguntas4 = new ListaDinamica<>();
                    preguntas5 = new ListaDinamica<>();
                    System.out.println("Respuesta Incorrecta, has perdido tus puntos acumulados");
                    this.guardarJugador();
                }

            } else {

                preguntas3 = new ListaDinamica<>();
                preguntas4 = new ListaDinamica<>();
                preguntas5 = new ListaDinamica<>();
                System.out.println("Fin del Juego, has conseguido: " + puntosTotales + " Puntos");
                this.guardarJugador();
            }
        }

    }

    public void guardarJugador() {

        FileWriter fichero = null;
        try {

            fichero = new FileWriter("Historial_jugador.txt");

            // Escribimos linea a linea en el fichero
            fichero.write("Jugador: " + name + "\n" + "puntos totales: " + puntosTotales + "\n");
            fichero.close();

        } catch (Exception ex) {
            System.out.println("No se logro guardar jugador,\n error: " + ex.getMessage());
        }
    }

    public void Categoria3() {

        //si estan vacias las preguntas, no hacemos nada
        if (!preguntas3.isEmpty()) {
            Scanner Entrada2 = new Scanner(System.in);
            System.out.println("Quiere Seguir a la tercera ronda ?");
            String Dec2 = Entrada2.nextLine();

            if (Dec2.equals("si")) {

                //Creamos un objeto leer
                Leer teclado = new Leer();

                int i = 0, respuesta3;
                Pregunta p;

                //recorremos las preguntas
                int A = (int) (Math.random() * 5);

                //Cojemos una pregunta
                p = preguntas3.get(A);

                //La mostramos
                p.mostrarPregunta();

                //Pedimos una respuesta
                respuesta3 = teclado.pedirIntRango(1, p.getRespuestas().size(), "Introduce el numero que representa la respuesta");

                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta3)) {
                    System.out.println("Has acertado" + " " + p.getPuntos() + "  puntos");
                    puntosTotales += p.getPuntos();
                    System.out.println("Puntos Acumulados: " + puntosTotales);
                    preguntas3 = new ListaDinamica<>();

                } else {

                    puntosTotales = 0;
                    preguntas3 = new ListaDinamica<>();
                    preguntas4 = new ListaDinamica<>();
                    preguntas5 = new ListaDinamica<>();
                    System.out.println("Respuesta Incorrecta, has perdido tus puntos acumulados");
                    this.guardarJugador();
                }

            } else {
                preguntas4 = new ListaDinamica<>();
                preguntas5 = new ListaDinamica<>();
                System.out.println("Fin del Juego, has conseguido: " + puntosTotales + " Puntos");
                this.guardarJugador();
            }
        }

    }

    public void Categoria4() {

        //si estan vacias las preguntas, no hacemos nada
        if (!preguntas4.isEmpty()) {
            Scanner Entrada2 = new Scanner(System.in);
            System.out.println("Quiere Seguir a la cuarta ronda ?");
            String Dec2 = Entrada2.nextLine();
            if (Dec2.equals("si")) {

                //Creamos un objeto leer
                Leer teclado = new Leer();

                int i = 0, respuesta4;
                Pregunta p;

                //recorremos las preguntas
                int A = (int) (Math.random() * 5);

                //Cojemos una pregunta
                p = preguntas4.get(A);

                //La mostramos
                p.mostrarPregunta();

                //Pedimos una respuesta
                respuesta4 = teclado.pedirIntRango(1, p.getRespuestas().size(), "Introduce el numero que representa la respuesta");

                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta4)) {
                    System.out.println("Has acertado" + " " + p.getPuntos() + "  puntos");
                    puntosTotales += p.getPuntos();
                    System.out.println("Puntos Acumulados: " + puntosTotales);
                    preguntas4 = new ListaDinamica<>();
                    this.guardarJugador();

                } else {

                    puntosTotales = 0;
                    preguntas4 = new ListaDinamica<>();
                    preguntas5 = new ListaDinamica<>();
                    System.out.println("Respuesta Incorrecta, has perdido tus puntos acumulados");
                    this.guardarJugador();
                }

            } else {
                preguntas5 = new ListaDinamica<>();
                System.out.println("Fin del Juego, has conseguido: " + puntosTotales + " Puntos");
                this.guardarJugador();
            }
        }

    }

    public void Categoria5() {

        //si estan vacias las preguntas, no hacemos nada
        if (!preguntas5.isEmpty()) {
            Scanner Entrada2 = new Scanner(System.in);
            System.out.println("Quiere Seguir a la quinta ronda?");
            String Dec2 = Entrada2.nextLine();

            if (Dec2.equals("si")) {

                //Creamos un objeto leer
                Leer teclado = new Leer();

                int i = 0, respuesta5;
                Pregunta p;;

                //recorremos las preguntas
                int A = (int) (Math.random() * 5);

                //Cojemos una pregunta
                p = preguntas5.get(A);

                //La mostramos
                p.mostrarPregunta();

                //Pedimos una respuesta
                respuesta5 = teclado.pedirIntRango(1, p.getRespuestas().size(), "Introduce el numero que representa la respuesta");

                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta5)) {
                    System.out.println("¡FELICIDADES! Has acertado todas las preguntas");
                    puntosTotales += p.getPuntos();
                    System.out.println("Puntos Acumulados: " + puntosTotales);
                    preguntas5 = new ListaDinamica<>();
                    this.guardarJugador();
                } else {

                    puntosTotales = 0;
                    preguntas5 = new ListaDinamica<>();
                    System.out.println("Respuesta Incorrecta, has perdido tus puntos acumulados");
                    this.guardarJugador();
                }

            } else {

                System.out.println("Fin del Juego, has conseguido: " + puntosTotales + " Puntos");
                this.guardarJugador();
            }

        }
    }

    public void cargarFichero(String fichero) throws FileNotFoundException, IOException {

        //Creo el buffer
        BufferedReader br = new BufferedReader(new FileReader(fichero));

        //variables necesarias
        String linea;
        Pregunta p;
        ListaDinamica<Respuesta> respuestas = new ListaDinamica<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;

        //leo el fichero
        while ((linea = br.readLine()) != null) {

            try {

                //si empieza por ;P; es una pregunta
                if (linea.startsWith(";P;")) {
                    texto_pregunta = linea.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea.startsWith(";R;")) {
                    opcioncorrecta = Integer.parseInt(linea.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, tomo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, tomo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas.addLast(new Respuesta(linea));

                    //Si tiene mas de 4 respuestas, lanzo excepcion
                    if (respuestas.size() > 4) {
                        throw new Exception();
                    }
                }

                //Si tenemos marcado la pregunta, la respuesta, los puntos y hay entre 2 y 4 opciones
                if (pregunta && respuesta && puntos && (respuestas.size() >= 2 && respuestas.size() <= 4)) {

                    //Marcamos la respuesta correcta como la correcta
                    respuestas.get(opcioncorrecta - 1).setCorrecta(true);

                    //creo la pregunta
                    p = new Pregunta(texto_pregunta, respuestas, puntosPregunta);

                    //añado la pregunta
                    preguntas.addLast(p);
                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas = new ListaDinamica<>();

                }

            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas = new ListaDinamica<>();
            }

        }

        br.close();

    }

    public void cargarFichero2(String fichero2) throws FileNotFoundException, IOException {

        //Creo el buffer
        BufferedReader br2 = new BufferedReader(new FileReader(fichero2));

        //variables necesarias
        String linea2;
        Pregunta p2;
        ListaDinamica<Respuesta> respuestas2 = new ListaDinamica<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;

        //leo el fichero
        while ((linea2 = br2.readLine()) != null) {

            try {

                //si empieza por ;P; es una pregunta
                if (linea2.startsWith(";g;")) {
                    texto_pregunta = linea2.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea2.startsWith(";h;")) {
                    opcioncorrecta = Integer.parseInt(linea2.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, tomo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea2.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, tomo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas2.addLast(new Respuesta(linea2));

                    //Si tiene mas de 4 respuestas, lanzo excepcion
                    if (respuestas2.size() > 4) {
                        throw new Exception();
                    }
                }

                //Si tenemos marcado la pregunta, la respuesta, los puntos y hay entre 2 y 4 opciones
                if (pregunta && respuesta && puntos && (respuestas2.size() >= 2 && respuestas2.size() <= 4)) {

                    //Marcamos la respuesta correcta como la correcta
                    respuestas2.get(opcioncorrecta - 1).setCorrecta(true);

                    //creo la pregunta
                    p2 = new Pregunta(texto_pregunta, respuestas2, puntosPregunta);

                    //añado la pregunta
                    preguntas2.addLast(p2);
                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas2 = new ListaDinamica<>();

                }

            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas2 = new ListaDinamica<>();
            }

        }

        br2.close();

    }

    public void cargarFichero3(String fichero3) throws FileNotFoundException, IOException {

        //Creo el buffer
        BufferedReader br3 = new BufferedReader(new FileReader(fichero3));

        //variables necesarias
        String linea3;
        Pregunta p3;
        ListaDinamica<Respuesta> respuestas3 = new ListaDinamica<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;

        //leo el fichero
        while ((linea3 = br3.readLine()) != null) {

            try {

                //si empieza por ;P; es una pregunta
                if (linea3.startsWith(";t;")) {
                    texto_pregunta = linea3.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea3.startsWith(";y;")) {
                    opcioncorrecta = Integer.parseInt(linea3.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, tomo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea3.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, tomo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas3.addLast(new Respuesta(linea3));

                    //Si tiene mas de 4 respuestas, lanzo excepcion
                    if (respuestas3.size() > 4) {
                        throw new Exception();
                    }
                }

                //Si tenemos marcado la pregunta, la respuesta, los puntos y hay entre 2 y 4 opciones
                if (pregunta && respuesta && puntos && (respuestas3.size() >= 2 && respuestas3.size() <= 4)) {

                    //Marcamos la respuesta correcta como la correcta
                    respuestas3.get(opcioncorrecta - 1).setCorrecta(true);

                    //creo la pregunta
                    p3 = new Pregunta(texto_pregunta, respuestas3, puntosPregunta);

                    //añado la pregunta
                    preguntas3.addLast(p3);
                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas3 = new ListaDinamica<>();

                }

            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas3 = new ListaDinamica<>();
            }

        }

        br3.close();

    }

    public void cargarFichero4(String fichero4) throws FileNotFoundException, IOException {

        //Creo el buffer
        BufferedReader br4 = new BufferedReader(new FileReader(fichero4));

        //variables necesarias
        String linea4;
        Pregunta p4;
        ListaDinamica<Respuesta> respuestas4 = new ListaDinamica<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;

        //leo el fichero
        while ((linea4 = br4.readLine()) != null) {

            try {

                //si empieza por ;P; es una pregunta
                if (linea4.startsWith(";a;")) {
                    texto_pregunta = linea4.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea4.startsWith(";b;")) {
                    opcioncorrecta = Integer.parseInt(linea4.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, tomo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea4.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, tomo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas4.addLast(new Respuesta(linea4));

                    //Si tiene mas de 4 respuestas, lanzo excepcion
                    if (respuestas4.size() > 4) {
                        throw new Exception();
                    }
                }

                //Si tenemos marcado la pregunta, la respuesta, los puntos y hay entre 2 y 4 opciones
                if (pregunta && respuesta && puntos && (respuestas4.size() >= 2 && respuestas4.size() <= 4)) {

                    //Marcamos la respuesta correcta como la correcta
                    respuestas4.get(opcioncorrecta - 1).setCorrecta(true);

                    //creo la pregunta
                    p4 = new Pregunta(texto_pregunta, respuestas4, puntosPregunta);

                    //añado la pregunta
                    preguntas4.addLast(p4);
                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas4 = new ListaDinamica<>();

                }

            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas4 = new ListaDinamica<>();
            }

        }

        br4.close();

    }

    public void cargarFichero5(String fichero5) throws FileNotFoundException, IOException {

        //Creo el buffer
        BufferedReader br5 = new BufferedReader(new FileReader(fichero5));

        //variables necesarias
        String linea5;
        Pregunta p5;
        ListaDinamica<Respuesta> respuestas5 = new ListaDinamica<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;

        //leo el fichero
        while ((linea5 = br5.readLine()) != null) {

            try {

                //si empieza por ;P; es una pregunta
                if (linea5.startsWith(";c;")) {
                    texto_pregunta = linea5.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea5.startsWith(";d;")) {
                    opcioncorrecta = Integer.parseInt(linea5.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, tomo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea5.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, tomo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas5.addLast(new Respuesta(linea5));

                    //Si tiene mas de 4 respuestas, lanzo excepcion
                    if (respuestas5.size() > 4) {
                        throw new Exception();
                    }
                }

                //Si tenemos marcado la pregunta, la respuesta, los puntos y hay entre 2 y 4 opciones
                if (pregunta && respuesta && puntos && (respuestas5.size() >= 2 && respuestas5.size() <= 4)) {

                    //Marcamos la respuesta correcta como la correcta
                    respuestas5.get(opcioncorrecta - 1).setCorrecta(true);

                    //creo la pregunta
                    p5 = new Pregunta(texto_pregunta, respuestas5, puntosPregunta);

                    //añado la pregunta
                    preguntas5.addLast(p5);
                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas5 = new ListaDinamica<>();

                }

            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas5 = new ListaDinamica<>();
            }

        }

        br5.close();

    }
}
