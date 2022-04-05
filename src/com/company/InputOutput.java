package com.company;
import java.util.Scanner;

public class InputOutput {

    //INSTANCIES
    Tablero tablero;
    Jugador jugador = new Jugador();

    Scanner sc = new Scanner(System.in);

    int coordenadaX;
    int coordenadaY;
    int dificultat;

    //EVENT GUANYAR-PERDUT
    boolean LoseWin;

    public void EleccioDificultat () {

        System.out.println("Indica la dificultat a la que es vol jugar " + jugador.getNombreJugador() + ":" +
                "\n 1 Facil" +
                "\n 2 Medio" +
                "\n 3 Dificil" +
                "\n 4 Personalitzat");
    }

    public void switchElectionDifficult () {

        dificultat = sc.nextInt();

        switch (dificultat) {
            case 1 -> {
                System.out.println("Dificultat Facil");
                tablero = new Tablero(8, 8, 10);
            }
            case 2 -> {
                System.out.println("Dificultat Medio");
                tablero = new Tablero(16, 16, 40);
            }
            case 3 -> {
                System.out.println("Dificultat Dificil");
                tablero = new Tablero(16, 30, 99);
            }
            case 4 -> {
                System.out.println("Dificultat Personalizada");
                System.out.println("Introdueix el numero de files");
                int filesCustom = sc.nextInt();
                System.out.println("Introdueix el numero de columnes");
                int columnesCustom = sc.nextInt();
                System.out.println("Introdueix el numero de mines");
                int minesCustom = sc.nextInt();
                tablero = new Tablero(filesCustom, columnesCustom, minesCustom);
            }
        }
        tablero.imprimirTablero();
        System.out.println("--------------------------");
    }
    public void JugarPartida () {

        int option;

        while(!LoseWin) {
            System.out.println("Introduce coordenadas X: ");
            coordenadaX = sc.nextInt() - 1;
            System.out.println("Introduce coordenadas y: ");
            coordenadaY = sc.nextInt() - 1;
            System.out.println("¿Quieres destapar o poner una bandera? Destapar.1 Bandera.2");
            option = sc.nextInt();
            if( option == 2){
                tablero.getTableroDeCasillas()[coordenadaX][coordenadaY].setBandera(true);
                tablero.imprimirTablero();
            }
            tablero.ObtCasillasAlrededor(coordenadaX,coordenadaY);
            if ( option == 1) {
                tablero.getTableroDeCasillas()[coordenadaX][coordenadaY].setTapado(true);
                tablero.imprimirTablero();

                if(tablero.getTableroDeCasillas()[coordenadaX][coordenadaY].isMina()){
                    LoseWin = true;
                    System.out.println("¡HAS PERDIDO!");
                }
                else{
                    tablero.ObtCasillasAlrededor(coordenadaX,coordenadaY);
                }
            }
            JugarPartida();
        }


    }
    public void joc () {
        jugador.Introduccio();
        EleccioDificultat();
        switchElectionDifficult();
        JugarPartida();
    }
}
