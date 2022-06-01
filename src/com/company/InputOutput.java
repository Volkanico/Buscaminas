package com.company;
import java.util.Scanner;

public class InputOutput {
    //INSTANCIES
    Tablero tablero;
    Jugador jugador;

    Scanner sc = new Scanner(System.in);
    int coordenadaX;
    int coordenadaY;
    int dificultat;

    public void introduccio () {
        System.out.println("¡Bienvenido a Buscaminas! :)");
        System.out.println("Introduce tu nombre: ");
        jugador = new Jugador(sc.nextLine());
        System.out.println("Tu nombre de jugador sera " + jugador.getNombreJugador());
        System.out.println("¡Empieza el juego!");
    }

    public void eleccioDificultat () {

        System.out.println("Indica la dificultad que quieres jugar " + jugador.getNombreJugador() + ":" +
                "\n 1 Facil" +
                "\n 2 Medio" +
                "\n 3 Dificil" +
                "\n 4 Personalitzat");
    }

    public void switchElectionDifficult () {

        int entrada = sc.nextInt();
        if ( entrada <= 4 && entrada > 0) {
            dificultat = entrada;
        }else{
            System.out.println("Este numero no existe");
            System.out.println("El ordenador va a explotar");
            System.exit(0);
        }
            switch (dificultat) {
                case 1 -> {
                    System.out.println("Dificultad Facil");
                    tablero = new Tablero(8, 8, 10);
                }
                case 2 -> {
                    System.out.println("Dificultad Medio");
                    tablero = new Tablero(16, 16, 40);
                }
                case 3 -> {
                    System.out.println("Dificultad Dificil");
                    tablero = new Tablero(16, 30, 99);
                }
                case 4 -> {
                    System.out.println("Dificultad Personalizada");
                    System.out.println("Introduce el numero de filas");
                    int filesCustom = sc.nextInt();
                    System.out.println("Introduce el numero de columnas");
                    int columnesCustom = sc.nextInt();
                    System.out.println("Introduce el numero de minas");
                    int minesCustom = sc.nextInt();
                    tablero = new Tablero(filesCustom, columnesCustom, minesCustom);
                }
            }
        tablero.imprimirTablero();
        System.out.println();
        System.out.println();
        //tablero.imprimirTableroPISTASYBOMBAS(coordenadaX,coordenadaY);
        System.out.println("------------------------------------------------");
    }
    public void jugarPartida () {
        int option;

            System.out.println("Introduce coordenadas X: ");
            coordenadaX = sc.nextInt() - 1;
            if (coordenadaX >= 0 && coordenadaX < tablero.getNumFilas()){
            System.out.println("Introduce coordenadas y: ");
            coordenadaY = sc.nextInt() - 1;
                if (coordenadaY >= 0 && coordenadaY < tablero.getNumColumnas()){
                System.out.println("¿Quieres destapar o poner una bandera? Destapar.1 Bandera.2");
                option = sc.nextInt();
                    if( option == 2){
                        tablero.getTableroDeCasillas()[coordenadaX][coordenadaY].setBandera(true);
                        tablero.imprimirTablero();
                    }
                    if ( option == 1) {
                        tablero.destaparCasilla(coordenadaX,coordenadaY);
                        tablero.imprimirTablero();
                    }
                } else {System.out.println("ERROR: Introduce nueva coordenada Y");}
            } else {System.out.println("ERROR: Introduce nueva coordenada X");}
            tablero.siesvictoria();
            this.jugarPartida();
    }
    public void joc () {
        this.introduccio();
        this.eleccioDificultat();
        this.switchElectionDifficult();
        this.jugarPartida();
    }
}
