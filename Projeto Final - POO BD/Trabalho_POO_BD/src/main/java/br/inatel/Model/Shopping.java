package br.inatel.Model;

public class Shopping {

    private String nome;
    private String endereco;
    private String horarioFuncionamento;

    public Shopping(String nome, String endereco, String horarioFuncionamento) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }
}
