public class Item implements Comparable<Item> {

    private int valor;
    private String nome;

    public Item(String nome, int valor) {
        this.valor = valor;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Item [nome=" + nome + ", valor=" + valor + "]";
    }

    @Override
    public int compareTo(Item item) {
        return Integer.compare(item.valor, this.valor);
    }
}
