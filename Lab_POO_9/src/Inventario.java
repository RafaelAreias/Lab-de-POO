import java.util.ArrayList;

public class Inventario {

    ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) throws ExcecaoLivroInvalido {
        if(livro.getTitulo().isEmpty())
            throw new ExcecaoLivroInvalido("Título vazio");

        if(livro.getPreco()<0)
            throw new ExcecaoLivroInvalido("Valor invalido");

        livros.add(livro);
    }

    public void exibirLivros() {
        if (livros.isEmpty())
            System.out.println("Inventário vazio");

        else
            for (Livro livro : livros)
                System.out.println("Título: " + livro.getTitulo() + " Autor: " + livro.getAutor() + " Preço: " + livro.getPreco());
    }
}
