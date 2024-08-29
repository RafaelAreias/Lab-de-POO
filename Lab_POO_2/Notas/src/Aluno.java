import java.util.Scanner;

public class Aluno {
    int matricula;
    int NP1;
    int NP2;
    int periodo;
    String nome;

    Scanner sc = new Scanner(System.in);

    int calculaMedia(){
        int media;
        media = (NP1 + NP2)/2;

        if (media >= 60)
            System.out.println("Aprovado");

        else if(media < 30)
            System.out.println("Reprovado");

        else
            calculaNP3(media);

        return 0;
    }

    int calculaNP3(int media){
        int NP3;
        System.out.println("Entre com a nota da NP3: ");
        NP3 = sc.nextInt();

        media = (NP3 + media)/2;

        if (media > 50)
            System.out.println("Aprovado");

        else
            System.out.println("Reprovado");

        return 0;
    }

    @Override
    public String toString() {
        return "Nome: "+nome + "\nMatricula: "+matricula + "\nPeriodo: "+periodo;
    }
}