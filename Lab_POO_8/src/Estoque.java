import java.util.ArrayList;

public class Estoque {

    private ArrayList<Item> itensArray = new ArrayList<>();

    public void adicionarArray(Item item){
        this.itensArray.add(item);
    }

    public void buscar(int posicao){
        if (posicao < itensArray.size() && posicao >= 0)
            System.out.println(itensArray.get(posicao));

        else
            System.out.println("Tente novamente, posição inválida");
    }

    public void deletar(int posicao){
        if (posicao < itensArray.size() && posicao >= 0)
            itensArray.remove(posicao);

        else
            System.out.println("Tente novamente, posição inválida");

    }

    public void deletar(Item item){
        if(itensArray.contains(item))
            itensArray.remove(item);

        else
            System.out.println("Item não encontrado");
    }

    public void modificar(Item item, int posicao){
        if (posicao < itensArray.size() && posicao >= 0)
            itensArray.set(posicao, item);

        else
            System.out.println("Tente novamente, posição inválida");
    }

    public ArrayList<Item> getItens() {
        return itensArray;
    }

    @Override
    public String toString() {
        return "Estoque [itensArray=" + itensArray + "]";
    }
}