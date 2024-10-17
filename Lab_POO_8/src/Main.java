import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        Item item0 = new Item("Arroz", 50);
        Item item1 = new Item("Feijao", 15);
        Item item2 = new Item("Macarrao", 10);
        Item item3 = new Item("Sal", 3);

        estoque.adicionarArray(item0);
        estoque.adicionarArray(item1);
        estoque.adicionarArray(item2);
        estoque.adicionarArray(item3);

        estoque.deletar(item3);

        estoque.buscar(0);

        estoque.deletar(2);


        Item item4 = new Item("banana", 8);
        estoque.modificar(item4, 0);

        Collections.sort(estoque.getItens());
        System.out.println(estoque);
    }
}