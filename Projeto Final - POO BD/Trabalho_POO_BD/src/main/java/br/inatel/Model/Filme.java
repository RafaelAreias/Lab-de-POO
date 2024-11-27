package br.inatel.Model;

public class Filme {

    private int idFilme;
    private String titulo;
    private int duracao;
    private Integer classificacao;

    public Filme(int idFilme, String titulo, int duracao, Integer classificacao) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public Integer getClassificacao() {
        return classificacao;
    }
}
