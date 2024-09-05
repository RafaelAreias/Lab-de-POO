import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Saga saga = new Saga();
        Livro livro = new Livro();

        System.out.println("Digite o nome do autor");
        Autor.setNome(sc.nextLine());

        System.out.println("Quantas sagas ele possui?");
        int quantidade = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite a nota da saga");
            saga.setNota(sc.nextInt());

            System.out.println("Quantos livros há na saga?");
            int tamanho = sc.nextInt();

            for (int j = 0; j < tamanho; j++) {
                System.out.println("Digite o título e o número de páginas");
                livro.setTitulo(sc.nextLine());
                livro.setPaginas(sc.nextInt());

                saga.adicionarLivro(livro);
            }

            Autor.adicionarSaga(saga);
        }
    }
}