package br.inatel.Model;

public class Ingresso {

    private int idIngresso;
    private float preco;
    private String poltrona;
    private int sessaoId;
    private int clienteId;

    public Ingresso(int idIngresso, float preco, String poltrona, int sessaoId, int clienteId) {
        this.idIngresso = idIngresso;
        this.preco = preco;
        this.poltrona = poltrona;
        this.sessaoId = sessaoId;
        this.clienteId = clienteId;
    }

    public Ingresso(float preco, String poltrona, int sessaoId, int clienteId) {
        this.preco = preco;
        this.poltrona = poltrona;
        this.sessaoId = sessaoId;
        this.clienteId = clienteId;
    }

    public int getIdIngresso() {
        return idIngresso;
    }

    public float getPreco() {
        return preco;
    }

    public String getPoltrona() {
        return poltrona;
    }

    public int getSessaoId() {
        return sessaoId;
    }

    public int getClienteId() {
        return clienteId;
    }
}
