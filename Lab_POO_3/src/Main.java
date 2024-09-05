import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Autor autor = new Autor();

        System.out.println("Digite o nome do autor");
        autor.setNome(sc.nextLine());

        System.out.println("Quantas sagas ele possui?");
        int quantidade = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            Saga saga = new Saga();

            System.out.println("Digite a nota da saga " + (i + 1));
            saga.setNota(sc.nextInt());

            System.out.println("Quantos livros há na saga " + (i + 1));
            int tamanho = sc.nextInt();

            for (int j = 0; j < tamanho; j++) {
                Livro livro = new Livro();

                System.out.println("Digite o título do livro " + (j + 1));
                livro.setTitulo(sc.next());
                System.out.println("A quantidade de páginas");
                livro.setPaginas(sc.nextInt());

                saga.adicionarLivro(livro);
            }

            autor.adicionarSaga(saga);
        }

        System.out.println("O autor " + autor.getNome() + " possui as seguintes obras:");

        autor.listarSagas();
    }
}