package com.company;

public class Casilla {
    private int posicioFila;
    private int posicioColumna;

    private boolean mina;
    private boolean bandera;
    private boolean tapado;

    private int numeroMinasAlrededor = 0;


    public Casilla(int posicioFila, int posicioColumna) {
        this.posicioFila = posicioFila;
        this.posicioColumna = posicioColumna;
    }


    public int getPosicioColumna() {
        return posicioColumna;
    }
    public void setPosicioColumna(int posicioColumna) {
        this.posicioColumna = posicioColumna;
    }

    public int getPosicioFila() {
        return posicioFila;
    }
    public void setPosicioFila(int posicioFila) {
        this.posicioFila = posicioFila;
    }

    public boolean isMina() {
        return mina;
    }
    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isBandera() {
        return bandera;
    }
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public boolean isTapado() {
        return tapado;
    }
    public void setTapado(boolean tapado) {
        this.tapado = tapado;
    }

    public int getNumeroMinasAlrededor() {
        return numeroMinasAlrededor;
    }

    public void setNumeroMinasAlrededor(int numeroMinasAlrededor) {
        this.numeroMinasAlrededor = numeroMinasAlrededor;
    }
}
/*

jugador: nom, torn,
InputOutput: entrada i sortide de dades
Tauler: format per caselles amb una matriu bidimensional
per fer els tres nivells, podriem fer 3 constructors diferents



caselles veïnes:
*/