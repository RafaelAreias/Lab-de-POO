package br.inatel.Model;

public class Sessao {

    private int idSessao;
    private String dataHorario;
    private int salaId;
    private int filmeId;

    public Sessao(int idSessao, String dataHorario, int salaId, int filmeId) {
        this.idSessao = idSessao;
        this.dataHorario = dataHorario;
        this.salaId = salaId;
        this.filmeId = filmeId;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public String getDataHorario() {
        return dataHorario;
    }

    public int getSalaId() {
        return salaId;
    }

    public int getFilmeId() {
        return filmeId;
    }
}
