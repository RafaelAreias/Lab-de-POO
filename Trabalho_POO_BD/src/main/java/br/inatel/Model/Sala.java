package br.inatel.Model;

public class Sala {

    private int numero;
    private int capacidade;
    private int id_cinema;

    public Sala(int capacidade, int numero, int id_cinema) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.id_cinema = id_cinema;
    }

    public Sala(int capacidade, int numero) {
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getId_cinema() {
        return id_cinema;
    }
}
