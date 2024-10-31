public class Jogo {
    private int id;
    private String nome;
    private double preco;

    public Jogo(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public void mostrarInfos(){
        System.out.println("Id: " + this.id + " Nome: " + this.nome + " Preco: " + this.preco);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
