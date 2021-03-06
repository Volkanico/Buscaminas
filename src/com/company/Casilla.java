package com.company;

public class Casilla {
    private final int posicioFila;
    private final int posicioColumna;

    private boolean mina = false;
    private boolean bandera = false;
    private boolean tapado = false;

    private int numeroMinasAlrededor = 0;


    public Casilla(int posicioFila, int posicioColumna) {
        this.posicioFila = posicioFila;
        this.posicioColumna = posicioColumna;
    }

    public int getPosicioFila() {return posicioFila;}

    public int getPosicioColumna() {return posicioColumna;}

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

