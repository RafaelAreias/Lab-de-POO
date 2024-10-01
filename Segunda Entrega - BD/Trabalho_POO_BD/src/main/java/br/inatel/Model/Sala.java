package br.inatel.Model;

public class Sala {

    int id_sala;
    int numero;
    int capacidade;

    public Sala(int numero, int capacidade, int id_sala) {
        this.id_sala = id_sala;
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getId_sala() {
        return id_sala;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
