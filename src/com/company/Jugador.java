package com.company;

import java.util.Scanner;

public class Jugador {
    private String nombreJugador;

    private final Scanner sc = new Scanner(System.in);

    public Jugador () {}

    public void Introduccio () {
        System.out.println("Introduce tu nombre: ");
        nombreJugador = sc.nextLine();
        System.out.println("¡Bienvenido a Buscaminas " + nombreJugador + "! :)");
    }
    public String getNombreJugador() {
        return nombreJugador;
    }
}
