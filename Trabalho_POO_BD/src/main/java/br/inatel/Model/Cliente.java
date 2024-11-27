package br.inatel.Model;

public class Cliente {

    private int idCliente;
    private String nome;
    private String idade;

    public Cliente(int idCliente, String nome, String idade) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.idade = idade;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }
}
