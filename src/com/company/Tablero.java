package com.company;

import java.util.ArrayList;

public class Tablero {
    private int numFilas;
    private int numColumnas;
    private Casilla[][] tableroDeCasillas = new Casilla[this.numFilas][this.numColumnas];
    private int numMinas;

    public Tablero(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        inicialitzarElJoc();
    }

    public void inicialitzarElJoc () {
        inicioCasillas();
        generarMinas();
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


    public void imprimirTablero() {
        for (Casilla[] tableroDeCasilla : tableroDeCasillas) {
            for (Casilla casilla : tableroDeCasilla) {
                if (casilla.isBandera()) {
                    System.out.print(casilla.isTapado() ? "[" + casilla.getNumeroMinasAlrededor() + "]" : "[P]");
                } else {
                    System.out.print(casilla.isTapado() ? "[" + casilla.getNumeroMinasAlrededor() + "]" : "[X]");
                }
                //casillas[i][j].isMina() ?  " *" : " X";
            }
            System.out.println();
        }
    }


    public ArrayList<Casilla> ObtCasillasAlrededor(int coordenadaX, int coordenadaY) {
        ArrayList<Casilla> casillasAlrededorComprMina = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < tableroDeCasillas.length; i++) {
            int posicioTemporalFila = coordenadaX;
            int posicioTemporalColumna = coordenadaY;

            switch (i) {
                case 0 -> posicioTemporalFila--;
                //Arriba
                case 1 -> {
                    posicioTemporalFila--;
                    posicioTemporalColumna++;
                } //Arriba Derecha
                case 2 -> posicioTemporalColumna++;
                //Derecha
                case 3 -> {
                    posicioTemporalColumna++;
                    posicioTemporalFila++;
                } //Abajo Derecha
                case 4 -> posicioTemporalFila++;
                //Abajo
                case 5 -> {
                    posicioTemporalFila++;
                    posicioTemporalColumna--;
                } //Abajo Izquierda
                case 6 -> posicioTemporalColumna--;
                //Izquierda
                case 7 -> {
                    posicioTemporalFila--;
                    posicioTemporalColumna--;
                } //Izquierda Arriba
            }


            if (posicioTemporalFila >= 0 && posicioTemporalFila < this.tableroDeCasillas.length
                    && posicioTemporalColumna >= 0 && posicioTemporalColumna < this.tableroDeCasillas[0].length) {

                casillasAlrededorComprMina.add(this.tableroDeCasillas[posicioTemporalFila][posicioTemporalColumna]);

                if(this.tableroDeCasillas[posicioTemporalFila][posicioTemporalColumna].isMina()) {
                    counter++;
                    tableroDeCasillas[coordenadaX][coordenadaY].setNumeroMinasAlrededor(counter);
                }
            }
            //destaparCasillasExpansion(coordenadaX,coordenadaY);
        }
        return casillasAlrededorComprMina;

    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    public Casilla[][] getTableroDeCasillas() {
        return tableroDeCasillas;
    }

    public void setTableroDeCasillas(Casilla[][] tableroDeCasillas) {
        this.tableroDeCasillas = tableroDeCasillas;
    }

    public int getNumMinas() {
        return numMinas;
    }

    public void setNumMinas(int numMinas) {
        this.numMinas = numMinas;
    }
}
