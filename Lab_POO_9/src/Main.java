public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        try {
            Livro livro1 = new Livro("1984", "George Orwell", 45.50);
            inventario.adicionarLivro(livro1);

            Livro livro2 = new Livro("Dom Casmurro", "Machado de Assis", -62.00);
            inventario.adicionarLivro(livro2);

        } catch (ExcecaoLivroInvalido e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Livro livro3 = new Livro("Ilíada", "Homero", 40.00);
            inventario.adicionarLivro(livro3);

            Livro livro4 = new Livro("", "Alice Doe", 32.99);
            inventario.adicionarLivro(livro4);

        } catch (ExcecaoLivroInvalido e) {
            System.out.println("Erro: " + e.getMessage());
        }

        inventario.exibirLivros();
    }
}