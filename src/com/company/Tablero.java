package com.company;

import java.util.ArrayList;

public class Tablero {
    private final int numFilas;
    private final int numColumnas;
    private Casilla[][] tableroDeCasillas;
    private final int numMinas;

    public Tablero(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        inicialitzarElJoc();
    }

    public void inicialitzarElJoc () {
        inicioCasillas();
        generarMinas();
        for (int i = 0; i < tableroDeCasillas.length; i++){
            for (int y = 0; y < tableroDeCasillas[i].length; y++){
                obtenirPistesDeMinesAlVoltant(i,y);
            }
        }
    }

    public void inicioCasillas() {
        tableroDeCasillas = new Casilla[this.numFilas][this.numColumnas];
        for (int i = 0; i < tableroDeCasillas.length; i++) {
            for (int j = 0; j < tableroDeCasillas[i].length; j++) {
                tableroDeCasillas[i][j] = new Casilla(i, j);
            }
        }
    }

    public void generarMinas() {
        int minasGeneradas = 0;
        while (minasGeneradas != numMinas) {
            int posicioTemporalFila = (int) (Math.random() * tableroDeCasillas.length);
            int posicioTemporalColumna = (int) (Math.random() * tableroDeCasillas[0].length);
            if (!tableroDeCasillas[posicioTemporalFila][posicioTemporalColumna].isMina()) {
                tableroDeCasillas[posicioTemporalFila][posicioTemporalColumna].setMina(true);
                minasGeneradas++;
            }
        }
    }

    public void destaparCasilla(int fila, int columna){
        if (!tableroDeCasillas[fila][columna].isBandera()){
        if(!tableroDeCasillas[fila][columna].isTapado()){
            tableroDeCasillas[fila][columna].setTapado(true);
            if(tableroDeCasillas[fila][columna].isMina()){
                imprimirTableroPISTASYBOMBAS(fila,columna);
                System.out.println("¡HAS PERDIDO MANCO! ");
                System.exit(0);

            }else{
                destaparCasillasVeines(fila, columna);
            }
        }
        }
    }
    private void destaparCasillasVeines(int fila, int columna) {
        ArrayList<Casilla> casillasVeines = obtenerCasillasVeines(fila, columna);
        for(Casilla casillaVeina : casillasVeines){
            if(casillaVeina.getNumeroMinasAlrededor() == 0){
                destaparCasilla(casillaVeina.getPosicioFila(), casillaVeina.getPosicioColumna());
            }else{
                casillaVeina.setTapado(true);
            }
        }
    }

    private ArrayList<Casilla> obtenerCasillasVeines(int fila, int columna) {
        ArrayList<Casilla> casillasVicines = new ArrayList<>();
        for(int filaVeina = fila - 1; filaVeina <= fila + 1; filaVeina++){
            for(int columnaVeina = columna - 1; columnaVeina <= columna + 1; columnaVeina++){
                if(filaVeina >= 0 && filaVeina < numFilas && columnaVeina >= 0 && columnaVeina < numColumnas){
                    if(!(filaVeina == fila && columnaVeina == columna)){
                        casillasVicines.add(tableroDeCasillas[filaVeina][columnaVeina]);
                    }
                }
            }
        }
        return casillasVicines;
    }

    public void obtenirPistesDeMinesAlVoltant (int fila, int columna) {
        int counter = 0;
        ArrayList<Casilla> casillasVeines = new ArrayList<>();
        for(int filaVicina = fila - 1; filaVicina <= fila + 1; filaVicina++){
            for(int columnaVicina = columna - 1; columnaVicina <= columna + 1; columnaVicina++){
                if(filaVicina >= 0 && filaVicina < numFilas && columnaVicina >= 0 && columnaVicina < numColumnas){
                    if(!(filaVicina == fila && columnaVicina == columna)){
                        casillasVeines.add(tableroDeCasillas[filaVicina][columnaVicina]);
                    }
                }
            }
        }
        for (int i = 0; i < casillasVeines.size(); i++){
            if (casillasVeines.get(i).isMina()){
                counter++;
                this.tableroDeCasillas[fila][columna].setNumeroMinasAlrededor(counter);
            }
        }
    }

    public void siesvictoria() {
        int contadorCasillas = 0;

        for (int i = 0; i < tableroDeCasillas.length; i++) {
            for (int j = 0; j < tableroDeCasillas[i].length; j++) {
                if ((!tableroDeCasillas[i][j].isMina() && tableroDeCasillas[i][j].isTapado()) ||
                        tableroDeCasillas[i][j].isBandera() ) {
                    contadorCasillas++;
                }
            }
        }
        if (contadorCasillas == numColumnas * numFilas) {
            System.out.println("¡HAS GANADO, ENHORABUENA! :) \n" +
                    "Creado por Volkan Moll ;)");
            System.exit(0);
        }
    }

    public void imprimirTablero() {
        for (Casilla[] tableroDeCasilla : tableroDeCasillas) {
            for (Casilla casilla : tableroDeCasilla) {
                if (casilla.isBandera()) {
                    System.out.print(casilla.isTapado() ? "[" + casilla.getNumeroMinasAlrededor() + "]" : "[P]");
                } else {
                    System.out.print(casilla.isTapado() ? "[" + casilla.getNumeroMinasAlrededor() + "]" : "[X]");
                }
            }
            System.out.println();
        }
    }

    public void imprimirTableroPISTASYBOMBAS(int fila, int columna) {
        tableroDeCasillas[fila][columna].setTapado(false);
        for (Casilla[] tableroDeCasilla : tableroDeCasillas) {
            for (Casilla casilla : tableroDeCasilla) {
                if (casilla.isMina()) {
                    System.out.print(casilla.isTapado() ? "[" + casilla.getNumeroMinasAlrededor() + "]" : "[*]");
                } else {
                    System.out.print("[" + casilla.getNumeroMinasAlrededor() + "]");
                }
            }
            System.out.println();
        }
    }

    public Casilla[][] getTableroDeCasillas() {
        return tableroDeCasillas;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }
}
