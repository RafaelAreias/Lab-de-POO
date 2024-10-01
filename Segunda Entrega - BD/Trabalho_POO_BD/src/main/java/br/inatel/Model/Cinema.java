package br.inatel.Model;

public class Cinema {

    int id_cinema;
    String nome;

    public Cinema(String nome, int id_cinema) {
        this.id_cinema = id_cinema;
        this.nome = nome;
    }

    public int getId_cinema() {
        return id_cinema;
    }

    public String getNome() {
        return nome;
    }
}

