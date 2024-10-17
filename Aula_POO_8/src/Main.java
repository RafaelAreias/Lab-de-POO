import br.inatel.cdg.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Conta[] contas = new Conta[100];
        contas[0] = new Conta();
        contas[1] = new Conta();

        Scanner sc = new Scanner(System.in);
        int entrada;
        float valor;
        int num;
        int user;

        contas[0].clientes[0].setNome("Rafael");
        contas[0].clientes[0].setCpf(105202966);
        contas[0].clientes[1].setNome("Luiz Gustavo");
        contas[0].clientes[1].setCpf(565538626);
        contas[1].clientes[0].setNome("Maria");
        contas[1].clientes[0].setCpf(442749636);
        contas[1].clientes[1].setNome("Júlia");
        contas[1].clientes[1].setCpf(692597376);

        System.out.println("Digite o número da conta");
        num = sc.nextInt();

        System.out.println("0-PRIMERO TITULAR  1-SEGUNDO TITULAR");
        user = sc.nextInt();

        System.out.println(contas[num].clientes[user].getNome());
        System.out.println(contas[num].clientes[user].getCpf());

        System.out.println("1-SACAR  2-DEPOSITAR");
        entrada = sc.nextInt();

        System.out.println("Digite o valor");
        valor  = sc.nextFloat();

        if(entrada == 1)
            contas[num].sacar(valor);

        else if(entrada == 2)
            contas[num].depositar(valor);
    }
}