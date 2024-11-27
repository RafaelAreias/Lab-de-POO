package br.inatel.Model;

public class Cinema {

    private int id_cinema;
    private String nome;
    private int id_shopping;

    public Cinema(String nome, int id_shopping) {
        this.nome = nome;
        this.id_shopping = id_shopping;
    }

    public int getId_cinema() {
        return id_cinema;
    }

    public String getNome() {
        return nome;
    }

    public int getId_shopping() {
        return id_shopping;
    }
}

